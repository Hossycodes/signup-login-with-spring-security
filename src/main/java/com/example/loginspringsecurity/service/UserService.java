package com.example.loginspringsecurity.service;

import com.example.loginspringsecurity.entity.ApplicationUser;
import com.example.loginspringsecurity.entity.Role;
import com.example.loginspringsecurity.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final PasswordEncoder encoder;
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("in the user detail service");
     return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("user not valid"));
    }

}
