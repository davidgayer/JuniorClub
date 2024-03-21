package com.davidgayer.junior.service;

import java.util.List;
import com.davidgayer.junior.dto.ClubDto;
import com.davidgayer.junior.model.Club;



public interface ClubService {
    List<ClubDto> findAllClubs();
    ClubDto findById(Long id);
    Club saveNewClub(ClubDto clubDto);  
    Club saveEditedClub(ClubDto clubDto);  
    void deleteById(Long id);
    List<ClubDto> searchClub(String query);
}


