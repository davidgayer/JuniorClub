package com.davidgayer.junior.dto;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.davidgayer.junior.model.Club;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

    @NotBlank(message="Title cannot be empty.")
    private String title;

    @NotBlank(message="Location cannot be empty.")
    private String location;

    @NotBlank(message="Title cannot be empty.")
    private String hostEmail;

    @NotBlank(message="Title cannot be empty.")
    private String content;

    private String imageUrl;

    @CreationTimestamp
    private LocalDateTime createdOn;

    @UpdateTimestamp
    private LocalDateTime updatedOn;

    @ManyToOne
    @JoinColumn(name = "club_id", nullable = false)
    private Club club;

}
