package org.lgs.lviv.education.controllers;

import org.lgs.lviv.education.entities.Certificate;
import org.lgs.lviv.education.entities.Faculty;
import org.lgs.lviv.education.entities.Subject;
import org.lgs.lviv.education.services.CertificateService;
import org.lgs.lviv.education.services.FacultyService;
import org.lgs.lviv.education.services.RequestService;
import org.lgs.lviv.education.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/apply")
public class RequestController {
    @Autowired
    private RequestService requestService;
    @Autowired
    private FacultyService facultyService;
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private CertificateService certificateService;

    @GetMapping
    public String getRequestPage(Model model, HttpServletRequest req){
        List<Faculty> faculties = facultyService.findAll();
        int userId = (int) req.getSession().getAttribute("userId");

        List<Subject> subjects = subjectService.findByUserId(userId);
        List<Certificate> certificates = certificateService.findByUserId(userId);

        model.addAttribute("faculties", faculties);
        model.addAttribute("subjects", subjects);
        model.addAttribute("certificates", certificates);

        return "applyPage";
    }
}
