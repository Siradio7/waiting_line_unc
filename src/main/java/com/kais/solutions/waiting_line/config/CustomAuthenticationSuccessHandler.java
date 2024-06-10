package com.kais.solutions.waiting_line.config;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        // Optionally, you can add logic here to handle after login actions
        // For example, you can log the authentication details
        System.out.println("User " + authentication.getName() + " has logged in successfully.");

        // Redirect to a default page after successful login
        response.sendRedirect("/");
    }
}
