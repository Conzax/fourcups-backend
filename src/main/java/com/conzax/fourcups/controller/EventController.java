package com.conzax.fourcups.controller;

import com.conzax.fourcups.entity.Account;
import com.conzax.fourcups.entity.Event;
import com.conzax.fourcups.entity.Game;
import com.conzax.fourcups.service.AccountService;
import com.conzax.fourcups.service.EventService;
import com.conzax.fourcups.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
public class EventController {

    @Autowired
    private final EventService tournamentService;
    private final AccountService accountService;
    private final GameService gameService;

    @Autowired
    public EventController(EventService tournamentService, AccountService accountService, GameService gameService) {
        this.tournamentService = tournamentService;
        this.accountService = accountService;
        this.gameService = gameService;
    }

    @PostMapping(value = "/api/secured/events")
    public ResponseEntity<?> create(Authentication authentication, @RequestBody Map<String, String> requestBody) {
        Account account = accountService.getByUsername(authentication.getName());
        Event event = new Event();
        event.setOwner(account.getId());
        if (requestBody.get("game") != null) {
            Game game = gameService.getById(UUID.fromString(requestBody.get("game")));
            event.setGame(game.getId());
        }
        event.setName(requestBody.get("name"));
        event.setDescription(requestBody.get("description"));
        tournamentService.create(event);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/api/secured/events")
    public ResponseEntity<List<Event>> all() {
        final List<Event> events = tournamentService.getAll();

        return events != null && !events.isEmpty()
                ? new ResponseEntity<>(events, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/api/secured/events/{id}")
    public ResponseEntity<Event> one(@PathVariable UUID id) {
        final Event event = tournamentService.getById(id);

        return event != null
                ? new ResponseEntity<>(event, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/api/secured/events/{id}/name")
    public ResponseEntity<?> updateName(@PathVariable UUID id, @RequestBody Map<String, String> requestBody) {
        tournamentService.updateName(id, requestBody.get("name"));

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/api/secured/events/{id}/description")
    public ResponseEntity<?> updateDesc(@PathVariable UUID id, @RequestBody Map<String, String> requestBody) {
        tournamentService.updateDescription(id, requestBody.get("description"));

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
