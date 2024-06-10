package com.kais.solutions.waiting_line.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = {RequestMethod.POST})
    public String auth(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");

        System.out.println("Test");
        System.out.println(username);

        return username;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
