package com.codewins.repository;

import com.codewins.modal.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  UserRepository extends JpaRepository<Users, Long> {
}
