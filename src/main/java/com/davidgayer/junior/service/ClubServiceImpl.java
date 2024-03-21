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

    @SuppressWarnings("null")
    @Override
    public Club saveNewClub(ClubDto clubDto) {
        return clubRepository.save(mapToClub(clubDto));
    }

    @SuppressWarnings("null")
    @Override
    public Club saveEditedClub(ClubDto clubDto) {
        return clubRepository.save(mapToClub(clubDto));
    }

    @SuppressWarnings("null")
    @Override
    public ClubDto findById(Long id) {
        ClubDto clubDto = mapToClubDto(clubRepository.findById(id).get());
        return clubDto;
    }

    @SuppressWarnings("null")
    public void deleteById(Long id) {
        clubRepository.deleteById(id);
    }

    public List<ClubDto> searchClub(String query) {
        List<Club> clubs = clubRepository.searchClubs(query);
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

    private Club mapToClub(ClubDto clubDto) {
        Club club = Club.builder()
                .id(clubDto.getId())
                .title(clubDto.getTitle())
                .content(clubDto.getContent())
                .imageUrl(clubDto.getImageUrl())
                .createdOn(clubDto.getCreatedOn())
                .updatedOn(clubDto.getUpdatedOn())
                .build();
        return club;
    }

    

}
