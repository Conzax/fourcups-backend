package com.conzax.fourcups.model_assembler;

import com.conzax.fourcups.controller.TournamentController;
import com.conzax.fourcups.entity.Tournament;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class TournamentModelAssembler implements RepresentationModelAssembler<Tournament, EntityModel<Tournament>> {

    @Override
    public EntityModel<Tournament> toModel(Tournament tournament) {
        return EntityModel.of(tournament,
                linkTo(methodOn(TournamentController.class).one(tournament.getId())).withSelfRel(),
                linkTo(methodOn(TournamentController.class).all()).withRel("accounts"));
    }
}
