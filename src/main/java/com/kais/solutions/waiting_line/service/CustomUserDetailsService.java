package com.kais.solutions.waiting_line.service;

import com.kais.solutions.waiting_line.model.Role;
import com.kais.solutions.waiting_line.model.User;
import com.kais.solutions.waiting_line.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.stereotype.Service;

import static org.springframework.security.core.userdetails.User.withUsername;

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        System.out.println(username);

        if (user == null) {
            throw new UsernameNotFoundException(username);
        }

        UserBuilder builder = withUsername(username);
        builder.password(user.getPassword());
        builder.roles(user.getRoles().stream().map(Role::getName).toArray(String[]::new));

        return builder.build();
    }
}
