package com.davidgayer.junior.service;

import java.util.List;
import com.davidgayer.junior.dto.ClubDto;
import com.davidgayer.junior.dto.EventDto;
import com.davidgayer.junior.model.Club;



public interface ClubService {
    List<ClubDto> findAllClubs();
    ClubDto getClubDetail(Long id);
    Club saveNewClub(ClubDto clubDto);  
    Club saveEditedClub(ClubDto clubDto);  
    void deleteClubById(Long id);
    List<ClubDto> searchClub(String query);
    List<EventDto> findAllClubEvents(Long clubId);
}


