package org.lgs.lviv.education.controllers;

import org.lgs.lviv.education.dtos.FacultyEditDto;
import org.lgs.lviv.education.entities.Faculty;
import org.lgs.lviv.education.entities.FacultySubjects;
import org.lgs.lviv.education.entities.Request;
import org.lgs.lviv.education.entities.Roles;
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

    @GetMapping("{faculty}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String facultyEditForm(@PathVariable Faculty faculty, Model model){
        model.addAttribute("faculty", faculty);
        model.addAttribute("subjects", FacultySubjects.values());

        return "facultyEditPage";
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public String facultyEdit(
            @RequestParam("id") Faculty faculty,
            @ModelAttribute FacultyEditDto facultyEditDto,
            @RequestParam Map<String, String> form
    ){
        faculty.setName(facultyEditDto.getName());
        faculty.setNumberOfSeats(facultyEditDto.getNumberOfSeats());

        faculty.getSubjects().clear();

        Set<String> subjects = Arrays.stream(FacultySubjects.values())
                .map(FacultySubjects::name)
                .collect(Collectors.toSet());

        for (String key : form.keySet()) {
            if (subjects.contains(key)){
                faculty.getSubjects().add(FacultySubjects.valueOf(key));
            }
        }

        facultyService.save(faculty);

        return "redirect:/faculty";
    }

    @GetMapping("/add")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String facultyAdd(Model model){
        model.addAttribute("subjects", FacultySubjects.values());

        return "facultyAdd";
    }

    @PostMapping("/add")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String facultyCreate(@ModelAttribute Faculty faculty, @RequestParam Map<String, String> form){
        Set<String> subjects = Arrays.stream(FacultySubjects.values())
                .map(FacultySubjects::name)
                .collect(Collectors.toSet());

        faculty.setSubjects(new HashSet<>());

        for (String key : form.keySet()) {
            if (subjects.contains(key)){
                faculty.getSubjects().add(FacultySubjects.valueOf(key));
            }
        }
        facultyService.create(faculty);

        return "redirect:/faculty";
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
