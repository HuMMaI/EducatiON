package org.lgs.lviv.education.controllers;

import org.lgs.lviv.education.services.RequestService;
import org.lgs.lviv.education.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@PreAuthorize("hasAuthority('ENROLLEE')")
@RequestMapping("/cabinet")
public class CabinetController {
    @Autowired
    private UserService userService;
    @Autowired
    private RequestService requestService;

    @GetMapping
    public String cabinet(Model model, HttpServletRequest request){
        return "cabinet";
    }

    @GetMapping("/edit")
    public String cabinetEditForm(){
        return "cabinetUserEdit";
    }
}
