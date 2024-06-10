package com.kais.solutions.waiting_line;

import com.kais.solutions.waiting_line.model.Student;
import com.kais.solutions.waiting_line.model.Role;
import com.kais.solutions.waiting_line.model.User;
import com.kais.solutions.waiting_line.repository.StudentRepository;
import com.kais.solutions.waiting_line.repository.RoleRepository;
import com.kais.solutions.waiting_line.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;

@Component
@AllArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private StudentRepository StudentRepository;
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
    }
}

