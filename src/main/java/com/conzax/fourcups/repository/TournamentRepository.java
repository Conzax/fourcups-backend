package com.conzax.fourcups.repository;

import com.conzax.fourcups.entity.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TournamentRepository extends JpaRepository<Tournament, UUID> {

    Optional<Tournament> findById(UUID id);
    Tournament findByAuthor(String username);
}