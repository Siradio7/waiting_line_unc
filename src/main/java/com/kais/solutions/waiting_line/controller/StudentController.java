package com.kais.solutions.waiting_line.controller;

import com.kais.solutions.waiting_line.model.Student;
import com.kais.solutions.waiting_line.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {

    @Autowired
    private StudentService StudentService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/verifier-scolarite")
    public String verifierScolarite(@RequestParam("matricule") String matricule, Model model) {
        Student Student = StudentService.verifierScolarite(matricule);
        if (Student != null && Student.isScolaritePayee()) {
            model.addAttribute("message", "L'étudiant a payé la scolarité.");
        } else {
            model.addAttribute("message", "L'étudiant n'a pas payé la scolarité.");
        }
        return "index";
    }
}
