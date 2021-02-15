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

    /**
     * Возвращает список существующих турниров
     * @return список турниров
     */
    public List<Tournament> getAll() {
        return tournamentRepository.findAll();
    }

    /**
     * Создает новый турнир
     * @param tournament турнир к созданию
     * @return созданный турнир
     */
    public Tournament create(Tournament tournament) {
        tournamentRepository.save(tournament);
        return tournament;
    }

    /**
     * Возвращает турнир по идентификатору
     * @param id идентификатор турнира
     * @return турнир
     */
    public Tournament getById(UUID id) {
        return tournamentRepository.findById(id)
                .orElseThrow(() -> new TournamentNotFoundException(id));
    }

    /**
     * Обновляет имя турнира
     * @param id идентификатор турнира
     * @param name новое имя турнира
     */
    public void updateName(UUID id, String name) {
        Optional<Tournament> optionalTournament = tournamentRepository.findById(id);
        Tournament tournament = optionalTournament.get();
        tournament.setName(name);
        tournamentRepository.save(tournament);
    }

    /**
     * Обновляет описание турнира
     * @param id идентификатор турнира
     * @param desc новое описание
     */
    public void updateDesc(UUID id, String desc) {
        Optional<Tournament> optionalTournament = tournamentRepository.findById(id);
        Tournament tournament = optionalTournament.get();
        tournament.setDesc(desc);
        tournamentRepository.save(tournament);
    }

    /**
     * Удаляет турнир по идентификатору
     * @param id идентификатор турнира
     */
    public void delete(UUID id) {
        tournamentRepository.deleteById(id);
    }

}
