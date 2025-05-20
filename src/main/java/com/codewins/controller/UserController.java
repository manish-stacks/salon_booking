package com.codewins.controller;

import com.codewins.modal.Users;
import com.codewins.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/api/users")
    public Users createUser(@RequestBody Users user) {
        return userRepository.save(user);
    }

    @GetMapping("/api/users")
    public Users getUser() {
        Users user = new Users();
        user.setFullName("Jack Bauer");
        user.setEmail("jack@codewins.com");
        user.setPhone("+91 123456789");
        user.setRole("ROLE_USER");

        return user;
    }
}
