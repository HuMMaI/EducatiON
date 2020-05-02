package org.lgs.lviv.education.controllers;

import org.lgs.lviv.education.entities.User;
import org.lgs.lviv.education.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class RegistrationController {
    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@ModelAttribute User user){
        Optional<User> userFromDb = userService.findByEmail(user.getEmail());

        if (userFromDb.isPresent()){
            return "registration";
        }

        userService.create(user);

        return "redirect:/login";
    }

    @GetMapping("/confirmEmail")
    public String confirmEmail(String hash){
        userService.confirmEmail(hash);

        return "redirect:/login";
    }
}
