package org.lgs.lviv.education.controllers;

import org.lgs.lviv.education.entities.Faculty;
import org.lgs.lviv.education.entities.FacultySubjects;
import org.lgs.lviv.education.entities.Roles;
import org.lgs.lviv.education.services.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

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
        model.addAttribute("subjects", FacultySubjects.values());

        return "facultyEditPage";
    }

    //todo make dto
    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public String facultyEdit(
            @RequestParam("id") Faculty faculty,
            @RequestParam String name,
            @RequestParam int numberOfSeats,
            @RequestParam Map<String, String> form
    ){
        faculty.setName(name);
        faculty.setNumberOfSeats(numberOfSeats);

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
    public String facultyAdd(){
        return "facultyAdd";
    }

    @PostMapping("/add")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String facultyCreate(@ModelAttribute Faculty faculty){
        facultyService.create(faculty);

        return "redirect:/faculty";
    }

    @GetMapping("/info")
    public String facultyInfo(@RequestParam("id") Faculty faculty, Model model){
        model.addAttribute("faculty", faculty);

        return "facultyInfo";
    }
}
