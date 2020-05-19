package org.lgs.lviv.education.controllers;

import org.lgs.lviv.education.entities.Faculty;
import org.lgs.lviv.education.entities.Request;
import org.lgs.lviv.education.entities.Statement;
import org.lgs.lviv.education.services.StatementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/statement/api")
public class StatementRestController {
    @Autowired
    private StatementService statementService;

    @PostMapping("/add")
    @PreAuthorize("hasAuthority('ADMIN')")
    private void addStatement(@RequestParam("id") Request request){
        statementService.save(request);
    }

    @GetMapping("/rating-list")
    @PreAuthorize("hasAuthority('ENROLLEE')")
    public List<Statement> getRatingList(@RequestParam("id") Faculty faculty){
        return statementService.getRatingList(faculty.getId());
    }

    @PostMapping("/cancel")
    @PreAuthorize("hasAuthority('ADMIN')")
    private void cancelStatement(@RequestParam("id") Request request){
        statementService.saveCanceledRequest(request);
    }

    @PostMapping("/result")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void statementResult(@RequestParam("facultyId") Faculty faculty){
        statementService.statementResult(faculty.getId(), faculty.getNumberOfSeats(), faculty.getName());
    }
}
