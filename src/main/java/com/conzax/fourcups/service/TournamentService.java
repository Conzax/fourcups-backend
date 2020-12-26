package com.conzax.fourcups.service;

import com.conzax.fourcups.entity.Account;
import com.conzax.fourcups.entity.Tournament;
import com.conzax.fourcups.repository.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TournamentService {

    @Autowired
    private TournamentRepository tournamentRepository;

    public List<Tournament> getAll() {
        return tournamentRepository.findAll();
    }

    public void save(Tournament tournament) {
        tournamentRepository.save(tournament);
    }

    public Tournament get(Long id) {
        return tournamentRepository.findById(id).get();
    }

    public void update(Long id, Tournament tournament) {}

    public void delete(Long id) {
        tournamentRepository.deleteById(id);
    }

}
