package org.lgs.lviv.education.controllers;

import org.lgs.lviv.education.entities.Certificate;
import org.lgs.lviv.education.entities.Subject;
import org.lgs.lviv.education.services.CertificateService;
import org.lgs.lviv.education.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/grades")
public class GradesController {
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private CertificateService certificateService;

    @GetMapping
    public String getGradesPage(Model model, HttpServletRequest request){
        List<Subject> subjects = subjectService.findAll();
        List<Certificate> certificates = certificateService.findAll();
        int userId = (int) request.getSession().getAttribute("userId");

        model.addAttribute("subjects", subjects);
        model.addAttribute("certificates", certificates);
        model.addAttribute("userId", userId);

        return "gradesPage";
    }

    @PostMapping("/add-subject")
    public String addSubject(@ModelAttribute Subject subject){
        subjectService.save(subject);

        return "redirect:/grades";
    }

    @PostMapping("/add-certificate")
    public String addCertificate(@ModelAttribute Certificate certificate){
        certificateService.save(certificate);

        return "redirect:/grades";
    }
}
