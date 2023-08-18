package com.example.loginspringsecurity.controller;

import com.example.loginspringsecurity.dto.LoginResponseDto;
import com.example.loginspringsecurity.dto.RegistrationDto;
import com.example.loginspringsecurity.entity.ApplicationUser;
import com.example.loginspringsecurity.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ApplicationUser registerUser (@RequestBody RegistrationDto body){
        return authenticationService.registerUser(body.getUsername(), body.getPassword());
    }
    @PostMapping("/login")
    public LoginResponseDto loginUser(@RequestBody RegistrationDto body){
        return authenticationService.loginUser(body.getUsername(), body.getPassword());
    }

}
