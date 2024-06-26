package com.davidgayer.junior.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationDto {

    private Long id;

    @NotEmpty
    private String userName;

    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    private String password;
}
