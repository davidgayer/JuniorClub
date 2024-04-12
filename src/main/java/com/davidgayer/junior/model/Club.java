package com.davidgayer.junior.model;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String imageUrl;
    private String content;

    @CreationTimestamp
    @DateTimeFormat(pattern = "dd.MM.yyyy, HH:mm")
    private LocalDateTime createdOn;

    @UpdateTimestamp
    @DateTimeFormat(pattern = "dd.MM.yyyy, HH:mm" )
    private LocalDateTime updatedOn;

    @OneToMany(mappedBy = "club", cascade = CascadeType.ALL)
    private List<Event> events;

}
