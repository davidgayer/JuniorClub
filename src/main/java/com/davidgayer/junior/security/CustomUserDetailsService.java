package com.davidgayer.junior.security;

import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.davidgayer.junior.model.UserEntity;
import com.davidgayer.junior.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService{

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUsername(username);
        if (userEntity != null) {
            User authUser = new User(
                userEntity.getUsername(),
                userEntity.getPassword(),
                userEntity.getRoles().stream().map((role) -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList())
            );
            return authUser;
        } else {
            throw new UsernameNotFoundException("Ivalid username or password!");
        }
    }
    
}
