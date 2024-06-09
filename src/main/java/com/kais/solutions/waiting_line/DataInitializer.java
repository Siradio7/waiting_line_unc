package com.kais.solutions.waiting_line;

import com.kais.solutions.waiting_line.model.Student;
import com.kais.solutions.waiting_line.model.Role;
import com.kais.solutions.waiting_line.model.User;
import com.kais.solutions.waiting_line.repository.StudentRepository;
import com.kais.solutions.waiting_line.repository.RoleRepository;
import com.kais.solutions.waiting_line.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private StudentRepository StudentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        Student Student1 = new Student();
        Student1.setNom("Doe");
        Student1.setPrenom("John");
        Student1.setMatricule("123456");
        Student1.setScolaritePayee(true);

        Student Student2 = new Student();
        Student2.setNom("Smith");
        Student2.setPrenom("Jane");
        Student2.setMatricule("654321");
        Student2.setScolaritePayee(false);

        StudentRepository.save(Student1);
        StudentRepository.save(Student2);

        // Initialiser un utilisateur admin
        Role adminRole = new Role();
        adminRole.setName("ADMIN");
        roleRepository.save(adminRole);

        User admin = new User();
        admin.setUsername("admin");
        admin.setPassword(passwordEncoder.encode("admin"));
        admin.setEnabled(true);
        admin.setRoles(new HashSet<>(List.of(adminRole)));

        userRepository.save(admin);
    }
}

