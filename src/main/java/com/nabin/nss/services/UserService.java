package com.nabin.nss.services;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * @author Narendra
 * @version 1.0
 * @since 2023-01-09
 */
@Service
public class UserService {

    private static List<UserDetails> APPLICATION_USERS = List.of(
            new User("nabin@gmail.com",
                    "$2a$12$/Rvd4souaP1Jwr3bVVNJaen0nwpDptXVsQTOkB/QAq1JGEl/NGMem",
                    Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMIN"))
            ),
            new User("abhiyan@gmail.com",
                    "$2a$12$9oFguVEwYzTIJahyg4UQtuDLLBgmwkNEFJtJDpU0vbrqriHAFT0lW",
                    Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMIN"))
            )
    );

    public UserDetails findByEmail(String email) {
        return APPLICATION_USERS
                .stream()
                .filter(u -> u.getUsername().equalsIgnoreCase(email))
                .findFirst()
                .orElseThrow(() -> new UsernameNotFoundException("User not found in the system"));
    }
}
