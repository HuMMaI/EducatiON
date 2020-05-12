package org.lgs.lviv.education.controllers;

import org.lgs.lviv.education.entities.Request;
import org.lgs.lviv.education.entities.User;
import org.lgs.lviv.education.services.RequestService;
import org.lgs.lviv.education.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@PreAuthorize("hasAuthority('ENROLLEE')")
@RequestMapping("/cabinet/api")
public class CabinetRestController {
    @Autowired
    private UserService userService;
    @Autowired
    private RequestService requestService;

    @GetMapping("/user-info")
    public User getUserInfo(HttpServletRequest request){
        HttpSession session = request.getSession();
        int userId = (int)session.getAttribute("userId");

        return userService.findById(userId);
    }

    @GetMapping("/request-info")
    public List<Request> getRequestInfo(@RequestParam("userId") int id){
        return requestService.findByUserId(id);
    }
}
