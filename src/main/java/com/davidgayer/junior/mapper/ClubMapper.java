package com.davidgayer.junior.mapper;

import java.util.stream.Collectors;

import com.davidgayer.junior.dto.ClubDto;
import com.davidgayer.junior.model.Club;

public class ClubMapper {

     public static ClubDto mapToClubDto(Club club) {
        ClubDto clubDto = ClubDto.builder()
                .id(club.getId())
                .title(club.getTitle())
                .content(club.getContent())
                .imageUrl(club.getImageUrl())
                .createdOn(club.getCreatedOn())
                .updatedOn(club.getUpdatedOn())
                .events(club.getEvents().stream().map(event -> EventMapper.mapToEventDto(event)).collect(Collectors.toList()))
                .build();
        return clubDto;
    }

    public static Club mapToClub(ClubDto clubDto) {
        Club club = Club.builder()
                .id(clubDto.getId())
                .title(clubDto.getTitle())
                .content(clubDto.getContent())
                .imageUrl(clubDto.getImageUrl())
                .createdOn(clubDto.getCreatedOn())
                .updatedOn(clubDto.getUpdatedOn())
                .events(clubDto.getEvents().stream().map(eventDto -> EventMapper.mapToEvent(eventDto)).collect(Collectors.toList()))
                .build();
        return club;
    }
    
}
