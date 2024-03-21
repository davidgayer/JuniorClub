package com.davidgayer.junior.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.davidgayer.junior.model.Club;

@Repository
public interface ClubRepository extends JpaRepository<Club, Long> {

    @Query("SELECT c FROM Club c WHERE c.title LIKE CONCAT('%', :query, '%')")
    List<Club> searchClubs(@Param("query") String query);
}
