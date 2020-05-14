package org.lgs.lviv.education.controllers;

import org.lgs.lviv.education.dtos.FacultyDto;
import org.lgs.lviv.education.entities.*;
import org.lgs.lviv.education.services.FacultyService;
import org.lgs.lviv.education.services.RequestService;
import org.lgs.lviv.education.services.SubjectService;
import org.lgs.lviv.education.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/faculty/api")
public class FacultyRestController {
    @Autowired
    private FacultyService facultyService;
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private UserService userService;
    @Autowired
    private RequestService requestService;

    @PostMapping("/add")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> facultyCreate(
            @Valid @ModelAttribute FacultyDto facultyDto,
            BindingResult bindingResult
    ){
        if (bindingResult.hasErrors()) {
            Map<String, String> errorsMap = ControllerUtil.errorMapper(bindingResult);

            return new ResponseEntity(errorsMap, HttpStatus.BAD_REQUEST);
        } else {
                Set<String> subjects = Arrays.stream(FacultySubjects.values())
                        .map(FacultySubjects::name)
                        .collect(Collectors.toSet());

            Faculty faculty = new Faculty();

            faculty.setName(facultyDto.getName());
            faculty.setNumberOfSeats(facultyDto.getNumberOfSeats());
            faculty.setSpecialization(facultyDto.getSpecialization());

            faculty.setSubjects(new HashSet<>());

            for (String key : facultyDto.getSubjects()) {
                if (subjects.contains(key)){
                    faculty.getSubjects().add(FacultySubjects.valueOf(key));
                }
            }
            facultyService.create(faculty);

            return new ResponseEntity(HttpStatus.OK);
        }
    }

    @GetMapping("/specializations")
    public List<String> getSpecializations(){
        return Stream.of(FacultySpecialization.values())
                .map(FacultySpecialization::toString)
                .collect(Collectors.toList());
    }


    @GetMapping("/add")
    @PreAuthorize("hasAuthority('ADMIN')")
    @ResponseStatus(HttpStatus.OK)
    public Map<FacultySubjects, String> getAddFacultyPage(){
        return Stream.of(FacultySubjects.values())
                .collect(Collectors.toMap(s -> s, FacultySubjects::toString));
    }

    @GetMapping("/edit")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Faculty facultyEditForm(@RequestParam("id") Faculty faculty){
        return faculty;
    }

    @PutMapping("/save")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> facultyEdit(
            @RequestParam("id") Faculty faculty,
            @Valid @ModelAttribute FacultyDto facultyDto,
            BindingResult bindingResult
    ){
        if (bindingResult.hasErrors()) {
            Map<String, String> errorsMap = ControllerUtil.errorMapper(bindingResult);

            return new ResponseEntity(errorsMap, HttpStatus.BAD_REQUEST);
        } else {
            faculty.setName(facultyDto.getName());
            faculty.setNumberOfSeats(facultyDto.getNumberOfSeats());
            faculty.setSpecialization(facultyDto.getSpecialization());

            faculty.getSubjects().clear();

            Set<String> subjects = Arrays.stream(FacultySubjects.values())
                    .map(FacultySubjects::name)
                    .collect(Collectors.toSet());

            for (String key : facultyDto.getSubjects()) {
                if (subjects.contains(key)) {
                    faculty.getSubjects().add(FacultySubjects.valueOf(key));
                }
            }

            facultyService.save(faculty);

            return new ResponseEntity(HttpStatus.OK);
        }
    }

    @PostMapping("/apply")
    @PreAuthorize("hasAuthority('ENROLLEE')")
    public ResponseEntity<?> apply(@ModelAttribute Request request){
        User user = request.getUser();
        Faculty faculty = request.getFaculty();

        Map<String, String> errorsMap = new HashMap<>();

        Set<String> userSubjects = subjectService.findByUserId(user.getId()).stream()
                .map(Subject::getName)
                .collect(Collectors.toSet());
        Set<String> subjects = faculty.getSubjects().stream()
                .map(FacultySubjects::toString)
                .collect(Collectors.toSet());

        if (userSubjects.isEmpty() || userSubjects.size() < subjects.size()){
            errorsMap.put("subjectsEmptyError", "Please, add information about subjects");

            return new ResponseEntity(errorsMap, HttpStatus.BAD_REQUEST);
        }

        if (!userSubjects.containsAll(subjects)){
            StringBuilder subjectStr = new StringBuilder();
            subjectStr.append("You have no such items: ");

            for (String key : subjects){
                if (!userSubjects.contains(key)){
                    subjectStr.append(key).append("; ");
                }
            }

            errorsMap.put("applyError", subjectStr.toString());
        }

        if (user.isApply()){
            errorsMap.put("applyError", "You have already applied!");
        }

        if (!errorsMap.isEmpty()){
            return new ResponseEntity(errorsMap, HttpStatus.BAD_REQUEST);
        }

        user.setApply(true);
        userService.save(user);

        requestService.save(request);

        return new ResponseEntity(HttpStatus.OK);
    }
}
