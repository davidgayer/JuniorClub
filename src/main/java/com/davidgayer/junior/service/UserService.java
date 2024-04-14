package com.davidgayer.junior.service;

import com.davidgayer.junior.dto.RegistrationDto;
import com.davidgayer.junior.model.UserEntity;

public interface UserService {

    void saveUser(RegistrationDto registrationDto);

    UserEntity findByEmail(String email);

    UserEntity findByUsername(String userName);

    

    
}
