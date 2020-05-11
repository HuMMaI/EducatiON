package org.lgs.lviv.education.controllers;

import org.lgs.lviv.education.dtos.GradeDto;
import org.lgs.lviv.education.entities.Certificate;
import org.lgs.lviv.education.entities.FacultySubjects;
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
    public List<Subject> getSubjects(){
        return subjectService.findAll();
    }

    @GetMapping("/certificate-list")
    public List<Certificate> getCertificate(){
        return certificateService.findAll();
    }

    @GetMapping("/subjects")
    public Map<FacultySubjects, String> getSubjectMap(){
        return Stream.of(FacultySubjects.values())
                .collect(Collectors.toMap(s -> s, FacultySubjects::toString));
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

        boolean isSubjectExist = subjectService.subjectCheck(gradeDto.getName(), userId);

        if (isSubjectExist){
            Map<String, String> errorMap = new HashMap<>();
            errorMap.put("existError", "You can`t added this subject because it has already been added!");

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

    @DeleteMapping("/subject-delete/{subject}")
    public void deleteSubject(@PathVariable Subject subject){
        subjectService.delete(subject);
    }
}
