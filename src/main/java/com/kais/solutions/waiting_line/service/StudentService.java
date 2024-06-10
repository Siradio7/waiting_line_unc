package com.kais.solutions.waiting_line.service;

import com.kais.solutions.waiting_line.model.Student;
import com.kais.solutions.waiting_line.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StudentService {

    private StudentRepository StudentRepository;

    public Student verifierScolarite(String matricule) {
        return StudentRepository.findByMatricule(matricule);
    }
}
