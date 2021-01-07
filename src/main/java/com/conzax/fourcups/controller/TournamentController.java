package com.conzax.fourcups.controller;

import com.conzax.fourcups.entity.Tournament;
import com.conzax.fourcups.service.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TournamentController {

    @Autowired
    private final TournamentService tournamentService;

    @Autowired
    public TournamentController(TournamentService tournamentService) {
        this.tournamentService = tournamentService;
    }

    @PostMapping(value = "/tournaments/follow")
    public ResponseEntity<?> follow(@RequestBody Long id, String nickname) {
        final Tournament tournament = tournamentService.get(id);
        final String[] followers = tournament.getFollowers();
        tournament.setFollowers(followers);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping(value = "/tournaments")
    public ResponseEntity<?> save(@RequestBody Tournament tournament) {
        tournamentService.save(tournament);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/tournaments")
    public ResponseEntity<List<Tournament>> get() {
        final List<Tournament> tournaments = tournamentService.getAll();

        return tournaments != null && !tournaments.isEmpty()
                ? new ResponseEntity<>(tournaments, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/tournaments/{id}")
    public ResponseEntity<Tournament> read(@PathVariable(name = "id") Long id) {
        final Tournament tournament = tournamentService.get(id);

        return tournament != null
                ? new ResponseEntity<>(tournament, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/tournaments/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") Long id, @RequestBody Tournament update) {
        final Tournament tournament = tournamentService.get(id);
        tournament.setName(update.getName());
        tournament.setDescription(update.getDescription());

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/tournaments/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id) {
        tournamentService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
