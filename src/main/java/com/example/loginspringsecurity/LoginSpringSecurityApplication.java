package com.example.loginspringsecurity;

import com.example.loginspringsecurity.entity.ApplicationUser;
import com.example.loginspringsecurity.entity.Role;
import com.example.loginspringsecurity.repository.RoleRepository;
import com.example.loginspringsecurity.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class LoginSpringSecurityApplication {


    public static void main(String[] args) {
        SpringApplication.run(LoginSpringSecurityApplication.class, args);
    }
        @Bean
    CommandLineRunner run(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder passwordEncoder){
        return args -> {
            Role adminRole = roleRepository.save(new Role(1,"ADMIN"));
            roleRepository.save(new Role(1, "USER"));
            Set<Role> roles = new HashSet<>();
            roles.add(adminRole);
            ApplicationUser admin = new ApplicationUser(1,"admin", passwordEncoder.encode("password"), roles);
            userRepository.save(admin);
        };
        }
}
