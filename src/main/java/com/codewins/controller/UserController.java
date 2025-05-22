package com.codewins.controller;

import com.codewins.modal.Users;
import com.codewins.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/api/user")
    public Users createUser(@RequestBody Users user) {
        return userRepository.save(user);
    }


    @GetMapping("/api/users")
    public List<Users> getUser() {
        return userRepository.findAll();
        //        Users user = new Users();
        //        user.setFullName("Jack Bauer");
        //        user.setEmail("jack@codewins.com");
        //        user.setPhone("+91 123456789");
        //        user.setRole("ROLE_USER");
        //
        //        return user;
    }

    //    if augument userId pass then PathVariable pass ("userId)
    @GetMapping("/api/user/{id}")
    public Users getUserById(@PathVariable Long id) throws Exception {
        Optional<Users> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        }
        throw new Exception("User not found");
    }


    @PutMapping("/api/user/{id}")
    public Users updateUser(@RequestBody Users users, @PathVariable Long id) throws Exception {
        Optional<Users> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new Exception("User not found" + id);
        }
        Users existingUser = user.get();
        existingUser.setFullName(users.getFullName());
        existingUser.setEmail(users.getEmail());
        existingUser.setPhone(users.getPhone());
        existingUser.setRole(users.getRole());
        return userRepository.save(existingUser);
    }
}
