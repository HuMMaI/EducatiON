package org.lgs.lviv.education.controllers;

import org.lgs.lviv.education.dtos.GradeDeleteDto;
import org.lgs.lviv.education.dtos.GradeDto;
import org.lgs.lviv.education.dtos.GradeUpdateDto;
import org.lgs.lviv.education.entities.Certificate;
import org.lgs.lviv.education.entities.SubjectNames;
import org.lgs.lviv.education.entities.Subject;
import org.lgs.lviv.education.entities.User;
import org.lgs.lviv.education.services.CertificateService;
import org.lgs.lviv.education.services.SubjectService;
import org.lgs.lviv.education.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@PreAuthorize("hasAuthority('ENROLLEE')")
@RequestMapping("/grades/api")
public class GradesRestController {
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private CertificateService certificateService;
    @Autowired
    private UserService userService;

    @GetMapping("/subjects-list")
    public List<Subject> getSubjects(@RequestParam("userId") int userId){
        return subjectService.findByUserId(userId);
    }

    @GetMapping("/certificate-list")
    public List<Certificate> getCertificate(@RequestParam("userId") int userId){
        return certificateService.findByUserId(userId);
    }

    @GetMapping("/current-user-subjects")
    public List<Subject> getSubjects(HttpServletRequest req){
        int userId = (int) req.getSession().getAttribute("userId");

        return subjectService.findByUserId(userId);
    }

    @GetMapping("/current-user-certificate")
    public List<Certificate> getCertificate(HttpServletRequest req){
        int userId = (int) req.getSession().getAttribute("userId");

        return certificateService.findByUserId(userId);
    }

    @GetMapping("/subjects")
    public Map<SubjectNames, String> getSubjectMap(){
        return Stream.of(SubjectNames.values())
                .collect(Collectors.toMap(s -> s, SubjectNames::toString));
    }

    @PostMapping("/add")
    public ResponseEntity<?> addSubject(
            @Valid @ModelAttribute GradeDto gradeDto,
            BindingResult bindingResult,
            HttpServletRequest request
    ){
        if (bindingResult.hasErrors()) {
            Map<String, String> errorsMap = ControllerUtil.errorMapper(bindingResult);

            return new ResponseEntity(errorsMap, HttpStatus.BAD_REQUEST);
        }

        int userId = (int) request.getSession().getAttribute("userId");

        boolean isSubjectExist;

        if (gradeDto.getGradeType().equals("subject")){
            isSubjectExist = subjectService.subjectCheck(gradeDto.getName(), userId);
        } else {
            isSubjectExist = certificateService.subjectCheck(gradeDto.getName(), userId);
        }

        if (isSubjectExist){
            Map<String, String> errorMap = new HashMap<>();
            errorMap.put(gradeDto.getGradeType() + "ExistError", "You can`t added this subject because it has already been added!");

            return new ResponseEntity(errorMap, HttpStatus.BAD_REQUEST);
        }

        boolean isSubjectsMoreThan;

        if (gradeDto.getGradeType().equals("subject")){
            isSubjectsMoreThan = subjectService.numberOfSubjectsCheck(userId);
        } else {
            isSubjectsMoreThan = certificateService.numberOfSubjectsCheck(userId);
        }

        if (!isSubjectsMoreThan){
            Map<String, String> errorMap = new HashMap<>();

            int numberOfSubjects = gradeDto.getGradeType().equals("subject") ? 4 : 6;

            String message = String.format("Can`t add more than %d subjects!", numberOfSubjects);
            errorMap.put(gradeDto.getGradeType() + "ExistError", message);

            return new ResponseEntity(errorMap, HttpStatus.BAD_REQUEST);
        }

        User user = userService.findById(userId);

        if (gradeDto.getGradeType().equals("subject")){
            Subject subject = new Subject();

            subject.setName(gradeDto.getName());
            subject.setGrade(gradeDto.getGrade());
            subject.setUser(user);

            subjectService.save(subject);
        } else {
            Certificate certificate = new Certificate();

            certificate.setName(gradeDto.getName());
            certificate.setGrade(gradeDto.getGrade());
            certificate.setUser(user);

            certificateService.save(certificate);
        }

        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/subject-delete")
    public void deleteSubject(@ModelAttribute GradeDeleteDto gradeDeleteDto){
        if (gradeDeleteDto.getGradeType().equals("subject")){
            subjectService.deleteById(gradeDeleteDto.getId());
        } else {
            certificateService.deleteById(gradeDeleteDto.getId());
        }
    }

    @PatchMapping("/subject-update")
    public void updateSubject(@Valid @ModelAttribute GradeUpdateDto gradeUpdateDto, BindingResult bindingResult){
        int grade = gradeUpdateDto.getGrade();

        if (bindingResult.hasErrors()){
            if (gradeUpdateDto.getGradeType().equals("subject")){
                grade = subjectService.getGradeById(gradeUpdateDto.getId());
            } else {
                grade = certificateService.getGradeById(gradeUpdateDto.getId());
            }
        }

        if (gradeUpdateDto.getGradeType().equals("subject")){
            subjectService.updateGrade(grade, gradeUpdateDto.getId());
        } else {
            certificateService.updateGrade(grade, gradeUpdateDto.getId());
        }
    }
}
