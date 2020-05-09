package org.lgs.lviv.education.controllers;

import org.lgs.lviv.education.dtos.UserEditDto;
import org.lgs.lviv.education.entities.Faculty;
import org.lgs.lviv.education.entities.Request;
import org.lgs.lviv.education.entities.User;
import org.lgs.lviv.education.services.FacultyService;
import org.lgs.lviv.education.services.RequestService;
import org.lgs.lviv.education.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

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

//        List<Integer> requestIds = requests.stream()
//                .map(Request::getId)
//                .collect(Collectors.toList());
//
//        List<String> facultyNames = requests.stream()
//                .map(Request::getFaculty)
//                .map(Faculty::getName)
//                .collect(Collectors.toList());

        model.addAttribute("user", user);
        model.addAttribute("requests", requests);
//        model.addAttribute("requestIds", requestIds);
//        model.addAttribute("facultyNames", facultyNames);

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
