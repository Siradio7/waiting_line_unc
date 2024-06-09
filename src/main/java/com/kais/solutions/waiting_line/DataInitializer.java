package com.kais.solutions.waiting_line;

import com.kais.solutions.waiting_line.model.Student;
import com.kais.solutions.waiting_line.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private StudentRepository StudentRepository;

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
    }
}

