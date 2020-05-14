package org.lgs.lviv.education.controllers;

import org.lgs.lviv.education.dtos.UserRegistrationDto;
import org.lgs.lviv.education.entities.User;
import org.lgs.lviv.education.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class RegistrationController {
    @Autowired
    private UserService userService;

    @Value("${appBaseDomain}")
    private String appBaseDomain;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(
            @ModelAttribute @Valid UserRegistrationDto userRegistrationDto,
            BindingResult bindingResult,
            Model model
    ) {
        if (userRegistrationDto.getPassword() != null
                        && !userRegistrationDto.getPassword().equals(userRegistrationDto.getPasswordConfirmation())) {
            model.addAttribute("passwordError", "Passwords are different!");
        }

        if (bindingResult.hasErrors()) {
            Map<String, String> errorsMap = bindingResult.getFieldErrors().stream()
                    .collect(Collectors.toMap(
                            fieldError -> fieldError.getField() + "Error",
                            FieldError::getDefaultMessage
                    ));

            model.mergeAttributes(errorsMap);

            return "registration";
        } else {
            User user = new User();
            user.setFirstName(userRegistrationDto.getFirstName());
            user.setLastName(userRegistrationDto.getLastName());
            user.setEmail(userRegistrationDto.getEmail());
            user.setPassword(userRegistrationDto.getPassword());

            Optional<User> userFromDb = userService.findByEmail(user.getEmail());

            if (userFromDb.isPresent()) {
                return "registration";
            }

            userService.create(user);
        }
        return "redirect:/login";
    }

    @GetMapping("/confirmEmail")
    public String confirmEmail(String hash) {
        userService.confirmEmail(hash);

        return "redirect:/login";
    }
}
