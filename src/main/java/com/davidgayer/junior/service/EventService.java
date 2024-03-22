package com.davidgayer.junior.service;

import java.util.List;

import com.davidgayer.junior.dto.EventDto;
import com.davidgayer.junior.model.Event;

public interface EventService {

    List<EventDto> getAllEvents();
    List<EventDto> getAllClubsEvents();
    Event findById(Long id);
    Event saveNewEvent(EventDto eventDto);
    Event saveEditedEvent(EventDto eventDto);
    void deleteById(Long id);
    Event searchEvent(String query);
    
}