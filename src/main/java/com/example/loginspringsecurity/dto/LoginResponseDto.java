package com.example.loginspringsecurity.dto;

import com.example.loginspringsecurity.entity.ApplicationUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginResponseDto {
    private ApplicationUser user;
    private String jwt;
}
