package org.lgs.lviv.education.controllers;

import org.lgs.lviv.education.entities.Request;
import org.lgs.lviv.education.entities.RequestStatus;
import org.lgs.lviv.education.services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@PreAuthorize("hasAuthority('ADMIN')")
@RequestMapping("/requests/api")
public class RequestRestController {
    @Autowired
    private RequestService requestService;

    @GetMapping
    public List<Request> getRequests(){
        return requestService.findAllByStatus(RequestStatus.WAITING.toString());
    }

    @DeleteMapping("/delete/{requestId}")
    public void deleteRequest(@PathVariable("requestId") int requestId){
        requestService.delete(requestId);
    }
}
