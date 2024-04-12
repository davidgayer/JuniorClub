package com.davidgayer.junior.service;

import com.davidgayer.junior.dto.RegistrationDto;
import com.davidgayer.junior.model.User;

public interface UserService {

    void saveUser(RegistrationDto registrationDto);

    User findByEmail(String email);

    User findByUsername(String userName);

    

    
}
