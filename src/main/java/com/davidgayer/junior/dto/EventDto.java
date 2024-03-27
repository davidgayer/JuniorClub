package com.davidgayer.junior.dto;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class EventDto {

    private Long id;

    @NotBlank(message="Name cannot be empty.")
    private String name;

    @NotBlank(message="Location cannot be empty.")
    private String location;

    @NotBlank(message="Host email cannot be empty.")
    @Email(message = "Email must have correct format.")
    private String hostEmail;

    @NotBlank(message="description cannot be empty.")
    private String description;

    @NotBlank(message="Image URL cannot be empty.")
    private String imageUrl;

    @DateTimeFormat(pattern = "dd.MM.yyyy, HH:mm")
    private LocalDateTime startTime;

    @DateTimeFormat(pattern = "dd.MM.yyyy, HH:mm")
    private LocalDateTime endTime;

    private LocalDateTime createdOn;

    private LocalDateTime updatedOn;
}
