package com.davidgayer.junior.service;

import org.springframework.stereotype.Service;

import com.davidgayer.junior.repository.EventRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EventServiceImpl {

    private final EventRepository eventRepository;
    
}
