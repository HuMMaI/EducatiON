package org.lgs.lviv.education.controllers;

import org.lgs.lviv.education.entities.Faculty;
import org.lgs.lviv.education.entities.Request;
import org.lgs.lviv.education.entities.Statement;
import org.lgs.lviv.education.services.StatementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/statement/api")
public class StatementRestController {
    @Autowired
    private StatementService statementService;

    @PostMapping("/add")
    private void addStatement(@RequestParam("id") Request request){
        statementService.save(request);
    }

    @GetMapping("/rating-list")
    public List<Statement> getRatingList(@RequestParam("id") Faculty faculty){
        return statementService.getRatingList(faculty.getId());
    }

    @PostMapping("/cancel")
    private void cancelStatement(@RequestParam("id") Request request){
        statementService.saveCanceledRequest(request);
    }
}
