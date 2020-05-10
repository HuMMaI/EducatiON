package org.lgs.lviv.education.controllers;

import org.lgs.lviv.education.dtos.FacultyEditDto;
import org.lgs.lviv.education.entities.Faculty;
import org.lgs.lviv.education.entities.FacultySubjects;
import org.lgs.lviv.education.entities.Request;
import org.lgs.lviv.education.services.FacultyService;
import org.lgs.lviv.education.services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/faculty")
public class FacultyController {
    @Autowired
    private FacultyService facultyService;
    @Autowired
    private RequestService requestService;

    @GetMapping
    public String facultyList(Model model, HttpServletRequest request){
        model.addAttribute("faculties", facultyService.findAll());

        return "facultyList";
    }

    @GetMapping("/edit")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String facultyEditForm(){
        return "facultyEditPage";
    }

    @GetMapping("/add")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String facultyAdd(){
        return "facultyAdd";
    }

    @GetMapping("/info")
    public String facultyInfo(@RequestParam("id") Faculty faculty, Model model, HttpServletRequest request){
        model.addAttribute("faculty", faculty);

        int userId = (int) request.getSession().getAttribute("userId");
        model.addAttribute("userId", userId);

        return "facultyInfo";
    }

    @PostMapping("/apply")
    public String apply(@ModelAttribute Request request){
        requestService.create(request);

        return "redirect:/faculty";
    }
}
