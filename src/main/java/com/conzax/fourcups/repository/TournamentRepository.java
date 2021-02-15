package com.conzax.fourcups.repository;

import com.conzax.fourcups.entity.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TournamentRepository extends JpaRepository<Tournament, UUID> {

    /**
     * Возвращает турнир в Optional<> по идентификатору
     * @param id идентификатор турнира
     * @return турнир в Optional<>
     */
    Optional<Tournament> findById(UUID id);

    /**
     * Возвращает турнир по имени пользователя автора
     * @param username имя пользователя автора
     * @return турнир
     */
    Tournament findByAuthor(String username);
}