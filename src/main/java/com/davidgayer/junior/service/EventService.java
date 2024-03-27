package com.davidgayer.junior.service;

import java.util.List;

import com.davidgayer.junior.dto.EventDto;

public interface EventService {
    
    void saveNewEvent(Long clubId, EventDto eventDto);
    List<EventDto> getEventsByClubId(Long clubId);
    List<EventDto> getAllEvents();
    
    
}
