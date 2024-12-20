package com.conzax.fourcups.repository;

import com.conzax.fourcups.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface GameRepository extends JpaRepository<Game, UUID> {

    Optional<Game> findById(UUID id);

    Game findByName(String name);
}