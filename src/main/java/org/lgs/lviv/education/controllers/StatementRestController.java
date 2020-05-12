package org.lgs.lviv.education.controllers;

import org.lgs.lviv.education.entities.Request;
import org.lgs.lviv.education.services.StatementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/statement/api")
public class StatementRestController {
    @Autowired
    private StatementService statementService;

    @PostMapping("/add")
    private void addStatement(@RequestParam("id") Request request){
        statementService.save(request);
    }
}
