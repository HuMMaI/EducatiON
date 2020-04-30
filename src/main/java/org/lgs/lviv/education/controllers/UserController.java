package org.lgs.lviv.education.controllers;

import org.lgs.lviv.education.entities.Roles;
import org.lgs.lviv.education.entities.User;
import org.lgs.lviv.education.repositories.UserRepository;
import org.lgs.lviv.education.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/user")
@PreAuthorize("hasAuthority('ADMIN')")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public String userList(Model model){
        model.addAttribute("users", userService.findAll());

        return "userList";
    }

    @GetMapping("{user}")
    public String userEditForm(@PathVariable User user, Model model){
        model.addAttribute("user", user);
        model.addAttribute("roles", Roles.values());

        return "userEditForm";
    }

    @PostMapping
    public String userSave(
            @RequestParam("id") User user,
            @RequestParam Map<String, String> form,
            @RequestParam String email
    ){
        user.setEmail(email);

        user.getRoles().clear();
        
        Set<String> roles = Arrays.stream(Roles.values())
                .map(Roles::name)
                .collect(Collectors.toSet());

        for (String key : form.keySet()) {
            if (roles.contains(key)){
                user.getRoles().add(Roles.valueOf(key));
            }
        }

        userService.save(user);

        return "redirect:/user";
    }
}
