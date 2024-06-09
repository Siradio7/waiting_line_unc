package com.kais.solutions.waiting_line.repository;

import com.kais.solutions.waiting_line.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
