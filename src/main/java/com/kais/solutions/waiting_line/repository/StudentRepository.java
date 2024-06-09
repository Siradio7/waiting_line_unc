package com.kais.solutions.waiting_line.repository;

import com.kais.solutions.waiting_line.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByMatricule(String matricule);
}
