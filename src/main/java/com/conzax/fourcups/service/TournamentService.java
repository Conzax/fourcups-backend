package com.conzax.fourcups.service;

import com.conzax.fourcups.entity.Tournament;
import com.conzax.fourcups.exception.TournamentNotFoundException;
import com.conzax.fourcups.repository.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TournamentService {

    @Autowired
    private TournamentRepository tournamentRepository;

    public List<Tournament> getAll() {
        return tournamentRepository.findAll();
    }

    public Tournament create(Tournament tournament) {
        tournamentRepository.save(tournament);
        return tournament;
    }

    public Tournament getById(UUID id) {
        return tournamentRepository.findById(id)
                .orElseThrow(() -> new TournamentNotFoundException(id));
    }

    public void updateName(UUID id, String name) {
        Optional<Tournament> optionalTournament = tournamentRepository.findById(id);
        Tournament tournament = optionalTournament.get();
        tournament.setName(name);
        tournamentRepository.save(tournament);
    }

    public void updateDesc(UUID id, String desc) {
        Optional<Tournament> optionalTournament = tournamentRepository.findById(id);
        Tournament tournament = optionalTournament.get();
        tournament.setDesc(desc);
        tournamentRepository.save(tournament);
    }

    public void delete(UUID id) {
        tournamentRepository.deleteById(id);
    }

}
