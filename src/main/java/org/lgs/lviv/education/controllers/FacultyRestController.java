package org.lgs.lviv.education.controllers;

import org.lgs.lviv.education.dtos.FacultyAddDto;
import org.lgs.lviv.education.entities.Faculty;
import org.lgs.lviv.education.entities.FacultySubjects;
import org.lgs.lviv.education.services.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/faculty/api")
public class FacultyRestController {
    @Autowired
    private FacultyService facultyService;

    @PostMapping("/add")
    @PreAuthorize("hasAuthority('ADMIN')")
    @ResponseStatus(HttpStatus.OK)
    public void facultyCreate(@ModelAttribute FacultyAddDto facultyAddDto){
        Set<String> subjects = Arrays.stream(FacultySubjects.values())
                .map(FacultySubjects::name)
                .collect(Collectors.toSet());

        Faculty faculty = new Faculty();

        faculty.setName(facultyAddDto.getName());
        faculty.setNumberOfSeats(facultyAddDto.getNumberOfSeats());

        faculty.setSubjects(new HashSet<>());

        for (String key : facultyAddDto.getSubjects()) {
            if (subjects.contains(key)){
                faculty.getSubjects().add(FacultySubjects.valueOf(key));
            }
        }
        facultyService.create(faculty);
    }

    @GetMapping("/add")
    @PreAuthorize("hasAuthority('ADMIN')")
    @ResponseStatus(HttpStatus.OK)
    public Map<FacultySubjects, String> getAddFacultyPage(){
        return Stream.of(FacultySubjects.values())
                .collect(Collectors.toMap(s -> s, FacultySubjects::toString));
    }
}
