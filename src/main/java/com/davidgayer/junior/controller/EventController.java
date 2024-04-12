package com.davidgayer.junior.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.davidgayer.junior.dto.EventDto;
import com.davidgayer.junior.service.EventService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
@RequestMapping(path = "/events")
public class EventController {

    private final EventService eventService;

    @GetMapping("/{clubId}/new")
    public String createEventForm(  @PathVariable("clubId") Long clubId, 
                                    Model model) {
                                        
        EventDto eventDto = new EventDto();
        model.addAttribute("clubId", clubId);
        model.addAttribute("event", eventDto);
        return "events/events-create";
    }

    @PostMapping("/{clubId}/saveEvent")
    public String saveNewEvent( @PathVariable("clubId") Long clubId,
                                @Valid @ModelAttribute("event") EventDto eventDto,
                                BindingResult bindingResult,
                                Model model) {

        if (bindingResult.hasErrors()) {
            return "events/events-create";
        }
        eventService.saveNewEvent(clubId, eventDto);
        return "redirect:/clubs/" + clubId + "/detail";
    }

    @GetMapping()
    public String listOfEvents(Model model) {

        List<EventDto> eventsDto = eventService.getAllEvents();
        model.addAttribute("events", eventsDto);
        return "events/events-list";
    }

    @GetMapping("/{eventId}/detail")
    public String eventDetail(  @PathVariable("eventId") Long eventId, 
                                Model model) {

        EventDto event = eventService.getEventDetail(eventId);
        model.addAttribute("event", event);
        return "events/events-detail";
    }

    @GetMapping("/{eventId}/edit")
    public String editEventForm(Model model, 
                                @PathVariable Long eventId) {

        EventDto eventDto = eventService.getEventDetail(eventId);
        model.addAttribute("event", eventDto);
        return "events/events-edit";
    }

    @PostMapping("/{eventId}/edit")
    public String saveEditedEvent(  @PathVariable Long eventId,
                                    @Valid @ModelAttribute("event") EventDto event,
                                    BindingResult bindingResult, 
                                    Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("event", event);
            return "events/events-edit";
        }
        EventDto eventDto = eventService.getEventDetail(eventId);
        event.setClub(eventDto.getClub());
        event.setId(eventId);
        eventService.saveEditedEvent(event);
        return "redirect:/events";
    }

    @GetMapping("/{eventId}/delete")
    public String deleteEvent(@PathVariable Long eventId) {
        eventService.deleteEventById(eventId);
        return "redirect:/events";
    }
    

}