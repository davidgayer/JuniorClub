package com.davidgayer.junior.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.davidgayer.junior.model.Club;

@Repository
public interface ClubRepository extends JpaRepository<Club, Long>{
    
}
