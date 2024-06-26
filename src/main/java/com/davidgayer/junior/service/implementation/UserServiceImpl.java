package com.davidgayer.junior.service.implementation;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.davidgayer.junior.dto.RegistrationDto;
import com.davidgayer.junior.model.Role;
import com.davidgayer.junior.model.UserEntity;
import com.davidgayer.junior.repository.RoleRepository;
import com.davidgayer.junior.repository.UserRepository;
import com.davidgayer.junior.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public void saveUser(RegistrationDto registrationDto) {
        UserEntity user = new UserEntity();
        user.setUsername(registrationDto.getUserName());
        user.setEmail(registrationDto.getEmail());
        user.setPassword(registrationDto.getPassword());
        Role role = roleRepository.findByName("USER");
        user.setRoles(Arrays.asList(role));
        userRepository.save(user);
    }

    @Override
    public UserEntity findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public UserEntity findByUsername(String userName) {
        return userRepository.findByUsername(userName);
    }
    
}
