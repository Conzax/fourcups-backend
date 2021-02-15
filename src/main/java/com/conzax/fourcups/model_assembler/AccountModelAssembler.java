package com.conzax.fourcups.model_assembler;

import com.conzax.fourcups.controller.AccountController;
import com.conzax.fourcups.entity.Account;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class AccountModelAssembler implements RepresentationModelAssembler<Account, EntityModel<Account>> {

    /**
     * Возвращает модель сущности от аккаунта
     * @param account аккаунт к модели
     * @return модель сущности от аккаунта, ссылку на него и ссылку на все турниры
     */
    @Override
    public EntityModel<Account> toModel(Account account) {
        return EntityModel.of(account,
                linkTo(methodOn(AccountController.class).one(account.getId())).withSelfRel(),
                linkTo(methodOn(AccountController.class).all()).withRel("accounts"));
    }
}
