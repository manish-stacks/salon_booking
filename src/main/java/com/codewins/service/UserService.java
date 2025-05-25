package com.codewins.service;

import com.codewins.exception.UserException;
import com.codewins.modal.Users;

import java.util.List;

public interface UserService {
    Users createUser(Users user);

    Users getUserById(Long id) throws UserException;

    List<Users> getAllUsers();

    void deleteUserById(Long id) throws Exception;

    Users updateUser(Long id, Users user) throws Exception;
}
