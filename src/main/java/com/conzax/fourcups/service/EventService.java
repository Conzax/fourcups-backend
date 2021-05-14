package com.conzax.fourcups.service;

import com.conzax.fourcups.entity.Event;
import com.conzax.fourcups.exception.EventNotFoundException;
import com.conzax.fourcups.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public List<Event> getAll() {
        return eventRepository.findAll();
    }

    public Event create(Event event) {
        eventRepository.save(event);
        return event;
    }

    public Event getById(UUID id) {
        return eventRepository.findById(id)
                .orElseThrow(() -> new EventNotFoundException(id));
    }

    public void updateName(UUID id, String name) {
        Optional<Event> optionalEvent = eventRepository.findById(id);
        Event event = optionalEvent.get();
        event.setName(name);
        eventRepository.save(event);
    }

    public void updateDescription(UUID id, String description) {
        Optional<Event> optionalEvent = eventRepository.findById(id);
        Event event = optionalEvent.get();
        event.setDescription(description);
        eventRepository.save(event);
    }

    public void delete(UUID id) {
        eventRepository.deleteById(id);
    }

}
