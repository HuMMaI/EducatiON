package org.lgs.lviv.education.controllers;

import org.lgs.lviv.education.services.CertificateService;
import org.lgs.lviv.education.services.FacultyService;
import org.lgs.lviv.education.services.RequestService;
import org.lgs.lviv.education.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@PreAuthorize("hasAuthority('ADMIN')")
@RequestMapping("/requests")
public class RequestController {
    @GetMapping
    public String getRequestPage(){
        return "userRequests";
    }
}
