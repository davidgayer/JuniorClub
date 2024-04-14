package com.davidgayer.junior.service.implementation;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.davidgayer.junior.dto.EventDto;
import com.davidgayer.junior.mapper.EventMapper;
import com.davidgayer.junior.model.Club;
import com.davidgayer.junior.model.Event;
import com.davidgayer.junior.repository.ClubRepository;
import com.davidgayer.junior.repository.EventRepository;
import com.davidgayer.junior.service.EventService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final ClubRepository clubRepository;

    @Override
    public void saveNewEvent(Long clubId, EventDto eventDto) {
        Optional<Club> clubOptional = clubRepository.findById(clubId);
        if (!clubOptional.isPresent()) {
            throw new IllegalArgumentException("Club not found with id: " + clubId);
        }
        Club club = clubOptional.get();
        Event event = EventMapper.mapToEvent(eventDto);
        event.setClub(club);
        eventRepository.save(event);
    }

    @Override
    public Event saveEditedEvent(EventDto eventDto) {
        Event event = EventMapper.mapToEvent(eventDto);
        return eventRepository.save(event);
    }

    @Override
    public List<EventDto> getEventsByClubId(Long clubId) {
        List<Event> events = eventRepository.findAllByClubId(clubId);
        return events.stream().map(EventMapper::mapToEventDto).collect(Collectors.toList());
    }

    @Override
    public List<EventDto> getAllEvents() {
        List<Event> events = eventRepository.findAll();
        return events.stream().map(EventMapper::mapToEventDto).collect(Collectors.toList());
    }

    @Override
    public EventDto getEventDetail(Long id) {
        Optional<Event> eventOptional = eventRepository.findById(id);
        if (!eventOptional.isPresent()) {
            throw new IllegalArgumentException("Event not found with id: " + id);
        }
        Event event = eventOptional.get();
        return EventMapper.mapToEventDto(event);
    }

    @Override 
    public void deleteEventById(Long eventId) {
        eventRepository.deleteById(eventId);
    }
}