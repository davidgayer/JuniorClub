package com.davidgayer.junior.service.implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.davidgayer.junior.dto.ClubDto;
import com.davidgayer.junior.dto.EventDto;
import com.davidgayer.junior.mapper.ClubMapper;
import com.davidgayer.junior.model.Club;
import com.davidgayer.junior.repository.ClubRepository;
import com.davidgayer.junior.service.ClubService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ClubServiceImpl implements ClubService {

    private final ClubRepository clubRepository;

    @Override
    public List<ClubDto> findAllClubs() {
        List<Club> clubs = clubRepository.findAll();
        return clubs.stream().map((club) -> ClubMapper.mapToClubDto(club)).collect(Collectors.toList());
    }

    @Override
    public Club saveNewClub(ClubDto clubDto) {
        return clubRepository.save(ClubMapper.mapToClub(clubDto));
    }

    @Override
    public Club saveEditedClub(ClubDto clubDto) {
        return clubRepository.save(ClubMapper.mapToClub(clubDto));
    }

    @Override
    public ClubDto getClubDetail(Long id) {
        ClubDto clubDto = ClubMapper.mapToClubDto(clubRepository.findById(id).get());
        return clubDto;
    }

    public void deleteClubById(Long id) {
        clubRepository.deleteById(id);
    }

    public List<ClubDto> searchClub(String query) {
        List<Club> clubs = clubRepository.searchClubs(query);
        return clubs.stream().map((club) -> ClubMapper.mapToClubDto(club)).collect(Collectors.toList());
    }

    @Override
    public List<EventDto> findAllClubEvents(Long clubId) {
        ClubDto clubDto = ClubMapper.mapToClubDto(clubRepository.findById(clubId).get());
        List<EventDto> eventsDto = clubDto.getEvents();
        return eventsDto;
    }


    

}
