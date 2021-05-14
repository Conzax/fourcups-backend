package com.conzax.fourcups.controller;

import com.conzax.fourcups.entity.Game;
import com.conzax.fourcups.service.AccountService;
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
public class GameController {

    @Autowired
    private final GameService gameService;
    private final AccountService accountService;

    @Autowired
    public GameController(GameService gameService, AccountService accountService) {
        this.gameService = gameService;
        this.accountService = accountService;
    }

    @PostMapping(value = "/api/secured/games")
    public ResponseEntity<?> create(Authentication authentication, @RequestBody Map<String, String> requestBody) {
        Game game = new Game();
        game.setName(requestBody.get("name"));
        gameService.create(game);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/api/secured/games")
    public ResponseEntity<List<Game>> all() {
        final List<Game> games = gameService.getAll();

        return games != null && !games.isEmpty()
                ? new ResponseEntity<>(games, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/api/secured/games/{id}")
    public ResponseEntity<Game> one(@PathVariable UUID id) {
        final Game game = gameService.getById(id);

        return game != null
                ? new ResponseEntity<>(game, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/api/secured/games/{id}/name")
    public ResponseEntity<?> updateName(@PathVariable UUID id, @RequestBody Map<String, String> requestBody) {
        gameService.updateName(id, requestBody.get("name"));

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
