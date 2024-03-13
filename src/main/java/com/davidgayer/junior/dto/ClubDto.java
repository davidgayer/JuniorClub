package com.davidgayer.junior.dto;

import java.time.LocalDateTime;

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
    private String title;
    private String imageUrl;
    private String content;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
    
}

