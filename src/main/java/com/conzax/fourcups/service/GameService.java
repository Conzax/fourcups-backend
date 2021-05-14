package com.conzax.fourcups.service;

import com.conzax.fourcups.entity.Event;
import com.conzax.fourcups.entity.Game;
import com.conzax.fourcups.exception.EventNotFoundException;
import com.conzax.fourcups.repository.EventRepository;
import com.conzax.fourcups.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<Game> getAll() {
        return gameRepository.findAll();
    }

    public Game create(Game game) {
        gameRepository.save(game);
        return game;
    }

    public Game getById(UUID id) {
        return gameRepository.findById(id)
                .orElseThrow(() -> new EventNotFoundException(id));
    }

    public void updateName(UUID id, String name) {
        Optional<Game> optionalGame = gameRepository.findById(id);
        Game game = optionalGame.get();
        game.setName(name);
        gameRepository.save(game);
    }

    public void delete(UUID id) {
        gameRepository.deleteById(id);
    }

}
