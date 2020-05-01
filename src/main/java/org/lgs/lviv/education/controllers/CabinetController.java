package org.lgs.lviv.education.controllers;

import org.lgs.lviv.education.dtos.UserEditDto;
import org.lgs.lviv.education.entities.User;
import org.lgs.lviv.education.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/cabinet")
public class CabinetController {
    @Autowired
    private UserService userService;

    @GetMapping
    public String cabinet(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        int userId = (int)session.getAttribute("userId");

        User user = userService.findById(userId);

        model.addAttribute("user", user);

        return "cabinet";
    }

    @GetMapping("{user}")
    public String cabinetEditForm(@PathVariable User user, Model model){
        model.addAttribute("user", user);

        return "cabinetUserEdit";
    }

    @PostMapping
    public String userEdit(@RequestParam("id") User user, @ModelAttribute UserEditDto userEditDto){
        user.setEmail(userEditDto.getEmail());
        user.setFirstName(userEditDto.getFirstName());
        user.setLastName(userEditDto.getLastName());
        user.setCoverId(userEditDto.getCoverId());

        userService.save(user);

        return "redirect:/cabinet";
    }
}
