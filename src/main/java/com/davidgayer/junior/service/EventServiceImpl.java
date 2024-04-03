package com.davidgayer.junior.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.davidgayer.junior.dto.EventDto;
import com.davidgayer.junior.model.Club;
import com.davidgayer.junior.model.Event;
import com.davidgayer.junior.repository.ClubRepository;
import com.davidgayer.junior.repository.EventRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final ClubRepository clubRepository;

    @SuppressWarnings("null")
    @Override
    public void saveNewEvent(Long clubId, EventDto eventDto) {
        Club club = clubRepository.findById(clubId).get();
        Event event = mapToEvent(eventDto);
        event.setClub(club);
        eventRepository.save(event);
    }

    @Override
    public List<EventDto> getEventsByClubId(Long clubId) {
        List<Event> events = eventRepository.findAllByClubId(clubId);
        return events.stream().map((event) -> mapToEventDto(event)).collect(Collectors.toList());
    }

    @Override
    public List<EventDto> getAllEvents() {
        List<Event> events = eventRepository.findAll();
        return events.stream().map((event) -> mapToEventDto(event)).collect(Collectors.toList());
    }

    @SuppressWarnings("null")
    @Override
    public EventDto getEventDetail(Long id) {
        Event event = eventRepository.findById(id).get();
        return mapToEventDto(event);

    }

    private Event mapToEvent(EventDto eventDto) {
        Event event = Event.builder()
                .id(eventDto.getId())
                .name(eventDto.getName())
                .location(eventDto.getLocation())
                .hostEmail(eventDto.getHostEmail())
                .description(eventDto.getDescription())
                .imageUrl(eventDto.getImageUrl())
                .startTime(eventDto.getStartTime())
                .endTime(eventDto.getEndTime())
                .createdOn(eventDto.getCreatedOn())
                .updatedOn(eventDto.getUpdatedOn())
                .build();
        return event;
    }

    private EventDto mapToEventDto(Event event) {
        EventDto eventDto = EventDto.builder()
                .id(event.getId())
                .name(event.getName())
                .location(event.getLocation())
                .hostEmail(event.getHostEmail())
                .description(event.getDescription())
                .imageUrl(event.getImageUrl())
                .startTime(event.getStartTime())
                .endTime(event.getEndTime())
                .createdOn(event.getCreatedOn())
                .updatedOn(event.getUpdatedOn())
                .build();
        return eventDto;
    }
}
