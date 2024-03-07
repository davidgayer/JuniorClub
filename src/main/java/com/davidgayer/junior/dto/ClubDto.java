package com.davidgayer.junior.dto;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClubDto {
  
    private Long id;
    private String title;
    private String imageUrl;
    private String content;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
    
}

