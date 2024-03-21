package com.davidgayer.junior.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.davidgayer.junior.model.Event;

public interface EventRepository extends JpaRepository<Event, Long> {
    
}
