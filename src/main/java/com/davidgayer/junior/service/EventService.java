package com.davidgayer.junior.service;

import java.util.List;

import com.davidgayer.junior.dto.EventDto;
import com.davidgayer.junior.model.Event;

public interface EventService {
    
    void saveNewEvent(Long clubId, EventDto eventDto);
    List<EventDto> getEventsByClubId(Long clubId);
    List<EventDto> getAllEvents();
    EventDto getEventDetail(Long id);
    Event saveEditedEvent(EventDto eventDto);
    void deleteEventById(Long eventId);
    
    
}
