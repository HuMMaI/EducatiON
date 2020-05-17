package org.lgs.lviv.education.controllers;

import org.lgs.lviv.education.dtos.CabinetUserEditDto;
import org.lgs.lviv.education.entities.Request;
import org.lgs.lviv.education.entities.User;
import org.lgs.lviv.education.services.RequestService;
import org.lgs.lviv.education.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

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

    @GetMapping("/user-edit")
    public CabinetUserEditDto getUser(HttpServletRequest request){
        int userId = (int) request.getSession().getAttribute("userId");

        User user = userService.findById(userId);

        CabinetUserEditDto cabinetUserEditDto = new CabinetUserEditDto();

        cabinetUserEditDto.setId(user.getId());
        cabinetUserEditDto.setFirstName(user.getFirstName());
        cabinetUserEditDto.setLastName(user.getLastName());
        cabinetUserEditDto.setEmail(user.getEmail());
        cabinetUserEditDto.setAge(user.getAge());
        cabinetUserEditDto.setGender(user.getGender());
        cabinetUserEditDto.setCountry(user.getCountry());
        cabinetUserEditDto.setCity(user.getCity());
        cabinetUserEditDto.setCoverId(user.getCoverId());

        return cabinetUserEditDto;
    }

    @PutMapping("/user-edit")
    public ResponseEntity<?> editUser(
            @Valid @ModelAttribute CabinetUserEditDto cabinetUserEditDto,
            BindingResult bindingResult
    ){
        if (bindingResult.hasErrors()){
            Map<String, String> errorsMap = ControllerUtil.errorMapper(bindingResult);

            return new ResponseEntity(errorsMap, HttpStatus.BAD_REQUEST);
        }

        User user = userService.findById(cabinetUserEditDto.getId());

        user.setFirstName(cabinetUserEditDto.getFirstName());
        user.setLastName(cabinetUserEditDto.getLastName());
        user.setEmail(cabinetUserEditDto.getEmail());
        user.setAge(cabinetUserEditDto.getAge());
        user.setGender(cabinetUserEditDto.getGender());
        user.setCountry(cabinetUserEditDto.getCountry());
        user.setCity(cabinetUserEditDto.getCity());
        user.setCoverId(cabinetUserEditDto.getCoverId());

        userService.save(user);

        return new ResponseEntity(HttpStatus.OK);
    }
}
