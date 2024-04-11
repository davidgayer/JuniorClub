package com.davidgayer.junior.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClubDto {
  
    private Long id;
    @NotBlank(message = "Club title cannot be empty.")
    private String title;
    @NotBlank(message = "Image URL cannot be empty.")
    private String imageUrl;
    @NotBlank(message = "Content cannot be empty.")
    private String content;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
    private List<EventDto> events = new ArrayList<>();
    
}

