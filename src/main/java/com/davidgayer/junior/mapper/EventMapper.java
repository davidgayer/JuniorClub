package com.davidgayer.junior.mapper;

import com.davidgayer.junior.dto.EventDto;
import com.davidgayer.junior.model.Event;

public class EventMapper {

     public static Event mapToEvent(EventDto eventDto) {
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

    public static EventDto mapToEventDto(Event event) {
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
