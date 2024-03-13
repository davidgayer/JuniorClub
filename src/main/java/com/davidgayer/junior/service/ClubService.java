package com.davidgayer.junior.service;

import java.util.List;
import com.davidgayer.junior.dto.ClubDto;
import com.davidgayer.junior.model.Club;



public interface ClubService {
    List<ClubDto> findAllClubs();
    Club saveNewClub(ClubDto clubDto);    
}


