package com.travelapp.controller;

import com.travelapp.entity.User;
import com.travelapp.form.AuthChangePasswordForm;
import com.travelapp.form.UserCreateForm;
import com.travelapp.service.interfaceService.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@Validated
@RestController
@RequestMapping(value = "api/auth")
public class AuthController {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private IUserService userService;


    @GetMapping("/login")
    public ProfileDTO login(Principal principal) {
        String userName = principal.getName();
        User user = userService.findUserByUserName(userName);
        return mapper.map(user, ProfileDTO.class);
    }

    @PostMapping("/register")
    public void register(@RequestBody @Valid UserCreateForm userCreateForm) {
        userService.createUser(userCreateForm);
    }

    @PutMapping("/change-password")
    public void changePassword(@RequestBody @Valid AuthChangePasswordForm authChangePasswordForm) {
        userService.changePassword(authChangePasswordForm);
    }
}


