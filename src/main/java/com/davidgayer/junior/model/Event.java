package com.davidgayer.junior.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import groovy.transform.builder.Builder;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    private String title;

    private String location;

    private String hostEmail;

    private String content;

    @CreationTimestamp
    private LocalDateTime createdOn;

    @UpdateTimestamp
    private LocalDateTime updatedOn;

    @ManyToOne
    @JoinColumn(name = "club_id", nullable = false)
    private Club club;

}
