package org.lgs.lviv.education.controllers;

import org.lgs.lviv.education.dtos.FacultyAddDto;
import org.lgs.lviv.education.entities.Faculty;
import org.lgs.lviv.education.entities.FacultySubjects;
import org.lgs.lviv.education.services.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public ResponseEntity<?> facultyCreate(
            @Valid @ModelAttribute FacultyAddDto facultyAddDto,
            BindingResult bindingResult,
            Model model
    ){
        if (bindingResult.hasErrors()) {
            Map<String, String> errorsMap = bindingResult.getFieldErrors().stream()
                    .collect(Collectors.toMap(
                            fieldError -> fieldError.getField() + "Error",
                            FieldError::getDefaultMessage
                    ));

            return new ResponseEntity(errorsMap, HttpStatus.BAD_REQUEST);
        } else {
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

            return new ResponseEntity(HttpStatus.OK);
        }
    }

    @GetMapping("/add")
    @PreAuthorize("hasAuthority('ADMIN')")
    @ResponseStatus(HttpStatus.OK)
    public Map<FacultySubjects, String> getAddFacultyPage(){
        return Stream.of(FacultySubjects.values())
                .collect(Collectors.toMap(s -> s, FacultySubjects::toString));
    }
}
