package com.codewins.service.imp;

import com.codewins.exception.UserException;
import com.codewins.modal.Users;
import com.codewins.repository.UserRepository;
import com.codewins.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public Users createUser(Users user) {
        return userRepository.save(user);
    }

    @Override
    public Users getUserById(Long id) throws UserException {
        Optional<Users> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        }
        throw new UserException("User not found");
    }

    @Override
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUserById(Long id) throws Exception {
        Optional<Users> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new Exception("User not found");
        }
        userRepository.deleteById(user.get().getId());

    }

    @Override
    public Users updateUser(Long id, Users users) throws Exception {
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
