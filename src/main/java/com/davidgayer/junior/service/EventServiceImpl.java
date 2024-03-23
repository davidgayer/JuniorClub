package com.davidgayer.junior.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.davidgayer.junior.dto.EventDto;
import com.davidgayer.junior.model.Event;
import com.davidgayer.junior.repository.EventRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    @Override
    public List<EventDto> getAllEvents() {
        List<Event> events = eventRepository.findAll();
        return events.stream().map((event) -> mapToEventDto(event)).collect(Collectors.toList());

    }

    @Override
    public List<EventDto> getAllClubsEvents(Long clubId) {
        List<Event> events = eventRepository.findAllByClubId(clubId);
        return events.stream().map((event) -> mapToEventDto(event)).collect(Collectors.toList());
    }

    @SuppressWarnings("null")
    @Override
    public EventDto findById(Long id) {
        Event event = eventRepository.findById(id).get();
        return mapToEventDto(event);
    }

    @SuppressWarnings("null")
    @Override
    public Event saveNewEvent(EventDto eventDto) {
        return eventRepository.save(mapToEvent(eventDto));
    }

    @SuppressWarnings("null")
    @Override
    public Event saveEditedEvent(EventDto eventDto) {
        return eventRepository.save(mapToEvent(eventDto));

    }

    @SuppressWarnings("null")
    @Override
    public void deleteById(Long id) {
        eventRepository.deleteById(id);
    }

    @Override
    public List<EventDto> searchEvent(String query) {
        List<Event> events = eventRepository.searchEvents(query);
        return events.stream().map((event) -> mapToEventDto(event)).collect(Collectors.toList());
    }

    private EventDto mapToEventDto(Event event) {
        EventDto eventDto = EventDto.builder()
                .id(event.getId())
                .title(event.getTitle())
                .location(event.getLocation())
                .hostEmail(event.getHostEmail())
                .content(event.getContent())
                .imageUrl(event.getImageUrl())
                .createdOn(event.getCreatedOn())
                .updatedOn(event.getUpdatedOn())
                .club(event.getClub())
                .build();
        return eventDto;
    }

    private Event mapToEvent(EventDto eventDto) {
        Event event = Event.builder()
                .id(eventDto.getId())
                .title(eventDto.getTitle())
                .location(eventDto.getLocation())
                .hostEmail(eventDto.getHostEmail())
                .content(eventDto.getContent())
                .imageUrl(eventDto.getImageUrl())
                .createdOn(eventDto.getCreatedOn())
                .updatedOn(eventDto.getUpdatedOn())
                .club(eventDto.getClub())
                .build();
        return event;
    }

}
