package com.davidgayer.junior.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.davidgayer.junior.dto.ClubDto;
import com.davidgayer.junior.model.Club;
import com.davidgayer.junior.repository.ClubRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ClubServiceImpl implements ClubService {

    private final ClubRepository clubRepository;

    @Override
    public List<ClubDto> findAllClubs() {
        List<Club> clubs = clubRepository.findAll();
        return clubs.stream().map((club) -> mapToClubDto(club)).collect(Collectors.toList()); 
    }

    private ClubDto mapToClubDto(Club club) {
        ClubDto clubDto = ClubDto.builder()
        .id(club.getId())
        .title(club.getTitle())
        .content(club.getContent())
        .imageUrl(club.getImageUrl())
        .createdOn(club.getCreatedOn())
        .updatedOn(club.getUpdatedOn())
        .build();
        return clubDto;
    }
    
}
