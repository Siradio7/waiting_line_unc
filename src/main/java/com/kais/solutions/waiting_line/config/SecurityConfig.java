package com.kais.solutions.waiting_line.config;

import com.kais.solutions.waiting_line.service.CustomUserDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration()
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {
    private CustomUserDetailsService userDetailsService;
    private CustomAuthenticationSuccessHandler authenticationSuccessHandler;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorizeHttpRequests -> {
                    authorizeHttpRequests
                            .anyRequest().permitAll();
                            //.requestMatchers("/login").permitAll();
                            //.requestMatchers("/**").hasRole("ADMIN")
                            //.anyRequest().authenticated();
        })
                .formLogin(formLoginConfigurer -> {
                    formLoginConfigurer
                            .loginPage("/login")
                            .loginProcessingUrl("/login")
                            .defaultSuccessUrl("/")
                            //.successHandler(authenticationSuccessHandler)
                            .permitAll();
        });
                /*
                .rememberMe(rememberMeConfigurer -> {
                    rememberMeConfigurer.userDetailsService(userDetailsService);
                })
                .logout(LogoutConfigurer::permitAll);
                */

        return http.build();
    }
}
