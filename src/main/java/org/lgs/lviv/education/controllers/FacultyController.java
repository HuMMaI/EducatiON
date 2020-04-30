package org.lgs.lviv.education.controllers;

import org.lgs.lviv.education.entities.Faculty;
import org.lgs.lviv.education.services.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/faculty")
public class FacultyController {
    @Autowired
    private FacultyService facultyService;

    @GetMapping
    public String facultyList(Model model, HttpServletRequest request){
        model.addAttribute("faculties", facultyService.findAll());

        return "facultyList";
    }

    @GetMapping("{faculty}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String facultyEditForm(@PathVariable Faculty faculty, Model model){
        model.addAttribute("faculty", faculty);

        return "facultyEditPage";
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public String facultyEdit(
            @RequestParam("id") Faculty faculty,
            @RequestParam String name,
            @RequestParam int numberOfSeats
    ){
        faculty.setName(name);
        faculty.setNumberOfSeats(numberOfSeats);

        facultyService.save(faculty);

        return "redirect:/faculty";
    }

    @GetMapping("/add")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String facultyAdd(){
        return "facultyAdd";
    }

    @PostMapping("/add")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String facultyCreate(@ModelAttribute Faculty faculty){
        facultyService.create(faculty);

        return "redirect:/faculty";
    }
}
