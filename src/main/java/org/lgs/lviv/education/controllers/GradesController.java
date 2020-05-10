package org.lgs.lviv.education.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@PreAuthorize("hasAuthority('ENROLLEE')")
@RequestMapping("/grades")
public class GradesController {
    @GetMapping
    public String getGradesPage(){
        return "gradesPage";
    }
}
