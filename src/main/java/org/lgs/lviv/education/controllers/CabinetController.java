package org.lgs.lviv.education.controllers;

import org.lgs.lviv.education.entities.Request;
import org.lgs.lviv.education.entities.User;
import org.lgs.lviv.education.services.RequestService;
import org.lgs.lviv.education.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/cabinet")
public class CabinetController {
    @Autowired
    private UserService userService;
    @Autowired
    private RequestService requestService;

    @GetMapping
    public String cabinet(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        int userId = (int)session.getAttribute("userId");

        User user = userService.findById(userId);
        List<Request> requests = requestService.findByUserId(userId);

        model.addAttribute("user", user);
        model.addAttribute("requests", requests);

        return "cabinet";
    }

    @GetMapping("/edit")
    public String cabinetEditForm(){
        return "cabinetUserEdit";
    }
}
