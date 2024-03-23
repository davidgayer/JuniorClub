package com.davidgayer.junior.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.davidgayer.junior.model.Event;

public interface EventRepository extends JpaRepository<Event, Long> {

    @Query("SELECT c FROM Event c WHERE c.title LIKE CONCAT('%', :query, '%')")
    List<Event> searchEvents(@Param("query") String query);

    List<Event> findAllByClubId(Long clubId);
    
}
