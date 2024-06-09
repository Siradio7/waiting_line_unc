package com.kais.solutions.waiting_line.repository;

import com.kais.solutions.waiting_line.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
