package com.conzax.fourcups.repository;

import com.conzax.fourcups.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface EventRepository extends JpaRepository<Event, UUID> {

    Optional<Event> findById(UUID id);

    Optional<Event> findByOwner(UUID username);
}