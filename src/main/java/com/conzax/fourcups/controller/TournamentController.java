package com.conzax.fourcups.controller;

import com.conzax.fourcups.entity.Tournament;
import com.conzax.fourcups.model_assembler.TournamentModelAssembler;
import com.conzax.fourcups.service.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class TournamentController {

    @Autowired
    private final TournamentService tournamentService;
    private final TournamentModelAssembler tournamentModelAssembler;

    /**
     * Устанавливает tournamentService и tournamentModelAssembler
     * @param tournamentService сервис турнира
     * @param tournamentModelAssembler сборщик модели турнира
     */
    @Autowired
    public TournamentController(TournamentService tournamentService, TournamentModelAssembler tournamentModelAssembler) {
        this.tournamentService = tournamentService;
        this.tournamentModelAssembler = tournamentModelAssembler;
    }

    /**
     * Возвращает сущность ответа
     * @param authentication аутентификация
     * @param requestBody тело запроса
     * @return сущность ответа со ссылкой на себя, модель сущности
     */
    @PostMapping(value = "/api/protected/tournaments")
    public ResponseEntity<?> create(Authentication authentication, @RequestBody Map<String, String> requestBody) {
        Tournament tournament = new Tournament();
        tournament.setName(requestBody.get("name"));
        tournament.setDesc(requestBody.get("desc"));
        tournament.setAuthor(authentication.getName());
        EntityModel<Tournament> entityModel = tournamentModelAssembler.toModel(tournamentService.create(tournament));

        return ResponseEntity
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(entityModel);
    }

    /**
     * Возвращает модель коллекции модели сущности от турнира
     * @return модель коллекции модели сущности от турнира
     */
    @GetMapping(value = "/api/protected/tournaments")
    public CollectionModel<EntityModel<Tournament>> all() {
        List<EntityModel<Tournament>> tournaments = tournamentService.getAll().stream()
                .map(tournamentModelAssembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(tournaments,
                linkTo(methodOn(TournamentController.class).all()).withSelfRel());
    }

    /**
     * Возвращает модель сущности от турнира
     * @param id идентификатор турнира
     * @return модель сущности от турнира
     */
    @GetMapping(value = "/api/protected/tournaments/{id}")
    public EntityModel<Tournament> one(@PathVariable UUID id) {
        Tournament tournament = tournamentService.getById(id);

        return tournamentModelAssembler.toModel(tournament);
    }

    /**
     * Возвращает пустую сущность ответа
     * @param id идентификатор турнира
     * @param requestBody тело запроса
     * @return пустую сущность ответа
     */
    @PutMapping(value = "/api/protected/tournaments/{id}/name")
    public ResponseEntity<?> updateName(@PathVariable UUID id, @RequestBody Map<String, String> requestBody) {
        tournamentService.updateName(id, requestBody.get("name"));

        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Возвращает пустую сущность ответа
     * @param id идентификатор туранира
     * @param requestBody тело запроса
     * @return пустую сущность ответа
     */
    @PutMapping(value = "/api/protected/tournaments/{id}/desc")
    public ResponseEntity<?> updateDesc(@PathVariable UUID id, @RequestBody Map<String, String> requestBody) {
        tournamentService.updateDesc(id, requestBody.get("desc"));

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
