package com.TrucksAuctions.services;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.TrucksAuctions.models.UserEntity;
import com.TrucksAuctions.repository.UsersRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{

    @Autowired
    UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity user = usersRepository.findByEmail(email);
        if (user != null) {
            return new org.springframework.security.core.userdetails.
            User(user.getEmail(),
                 user.getPassword(),
                 Collections.singleton(new SimpleGrantedAuthority
                                        (user.getRole())));
        } else {
            throw new UsernameNotFoundException("Invalid email or password!");
        }
    }
}
