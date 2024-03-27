package com.davidgayer.junior.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.davidgayer.junior.model.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    @Query("SELECT c FROM Event c WHERE c.name LIKE CONCAT('%', :query, '%')")
    List<Event> searchEvents(@Param("query") String query);

    List<Event> findAllByClubId(Long clubId);
    
}
