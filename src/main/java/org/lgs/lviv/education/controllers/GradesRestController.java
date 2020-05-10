package org.lgs.lviv.education.controllers;

import org.lgs.lviv.education.dtos.GradeDto;
import org.lgs.lviv.education.entities.Certificate;
import org.lgs.lviv.education.entities.Subject;
import org.lgs.lviv.education.entities.User;
import org.lgs.lviv.education.services.CertificateService;
import org.lgs.lviv.education.services.SubjectService;
import org.lgs.lviv.education.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
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
}
