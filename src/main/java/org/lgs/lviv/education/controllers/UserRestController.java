package org.lgs.lviv.education.controllers;

import org.lgs.lviv.education.dtos.UserDto;
import org.lgs.lviv.education.dtos.UserEditDto;
import org.lgs.lviv.education.entities.Roles;
import org.lgs.lviv.education.entities.User;
import org.lgs.lviv.education.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user/api")
@PreAuthorize("hasAuthority('ADMIN')")
public class UserRestController {
    @Autowired
    private UserService userService;

    @GetMapping("/edit")
    public User userEditForm(@RequestParam("id") int id){
        return userService.findById(id);
    }

    @GetMapping("/roles")
    public List<Roles> getRoles(){
        return Arrays.asList(Roles.values());
    }

    @GetMapping
    public List<User> getUsers(){
        return userService.findAll();
    }

    @GetMapping("/find")
    public UserEditDto getUser(@RequestParam("id") User user){
        UserEditDto userEditDto = new UserEditDto();

        userEditDto.setFirstName(user.getFirstName());
        userEditDto.setLastName(user.getLastName());
        userEditDto.setEmail(user.getEmail());
        userEditDto.setCoverId(user.getCoverId());

        return userEditDto;
    }

    @PutMapping("/edit")
    public ResponseEntity<?> userSave(
            @RequestParam("id") User user,
            @Valid @ModelAttribute UserDto userDto,
            BindingResult bindingResult
    ){
        if (bindingResult.hasErrors()){
            Map<String, String> errorsMap = ControllerUtil.errorMapper(bindingResult);

            return new ResponseEntity(errorsMap, HttpStatus.BAD_REQUEST);
        }

        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());

        user.getRoles().clear();

        Set<String> roles = Arrays.stream(Roles.values())
                .map(Roles::name)
                .collect(Collectors.toSet());

        for (String key : userDto.getRoles()) {
            if (roles.contains(key)){
                user.getRoles().add(Roles.valueOf(key));
            }
        }

        userService.save(user);

        return new ResponseEntity(HttpStatus.OK);
    }
}
