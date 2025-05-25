package com.codewins.controller;

import com.codewins.exception.UserException;
import com.codewins.modal.Users;
import com.codewins.repository.UserRepository;
import com.codewins.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class UserController {

//    @Autowired
//    private UserRepository userRepository;

    private final UserService userService;

    @GetMapping("/api/users")
    public ResponseEntity<List<Users>> getUser() {
        List<Users> users = userService.getAllUsers();
        return new ResponseEntity<>(users,HttpStatus.OK);


        //        Users user = new Users();
        //        user.setFullName("Jack Bauer");
        //        user.setEmail("jack@codewins.com");
        //        user.setPhone("+91 123456789");
        //        user.setRole("ROLE_USER");
        //
        //        return user;
    }

    @PostMapping("/api/user")
    public ResponseEntity<Users> createUser(@RequestBody @Valid Users user) {
        Users createUser = userService.createUser(user);
        return new ResponseEntity<>(createUser, HttpStatus.CREATED);
    }

    //    if augument userId pass then PathVariable pass ("userId)
    @GetMapping("/api/user/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable Long id) throws Exception {
            Users user = userService.getUserById(id);
            return new ResponseEntity<>(user,HttpStatus.OK);
    }


    @PutMapping("/api/user/{id}")
    public ResponseEntity<Users> updateUser(@RequestBody Users users, @PathVariable Long id) throws Exception {
        Users user = userService.updateUser(id,users);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @DeleteMapping("/api/user/{id}")
    public ResponseEntity<String> deleteUserNyId(@PathVariable Long id) throws Exception {
        userService.deleteUserById(id);
        return new ResponseEntity<>("User deleted",HttpStatus.ACCEPTED);
    }
}
