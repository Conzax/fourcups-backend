package com.conzax.fourcups.controller;

import com.conzax.fourcups.entity.Account;
import com.conzax.fourcups.model_assembler.AccountModelAssembler;
import com.conzax.fourcups.service.AccountService;
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
public class AccountController {

    @Autowired
    private final AccountService accountService;
    private final AccountModelAssembler accountModelAssembler;

    /**
     * Устанавливает accountService и accountModelAssembler
     * @param accountService сервис аккаунта
     * @param accountModelAssembler сборщик модели аккаунта
     */
    @Autowired
    public AccountController(AccountService accountService, AccountModelAssembler accountModelAssembler) {
        this.accountService = accountService;
        this.accountModelAssembler = accountModelAssembler;
    }

    /**
     * Возвращает сущность ответа
     * @param account аккаунт
     * @return сущность ответа с ссылкой на себя, модель сущности
     */
    @PostMapping(value = "/api/public/accounts")
    public ResponseEntity<?> create(@RequestBody Account account) {
        EntityModel<Account> entityModel = accountModelAssembler.toModel(accountService.create(account));

        return ResponseEntity
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(entityModel);
    }

    /**
     * Возвращает модель коллекции модели сущности аккаунта
     * @return модель коллекции модель сущности аккаунта
     */
    @GetMapping(value = "/api/protected/accounts")
    public CollectionModel<EntityModel<Account>> all() {
        List<EntityModel<Account>> accounts = accountService.getAll().stream()
                .map(accountModelAssembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(accounts,
                linkTo(methodOn(AccountController.class).all()).withSelfRel());
    }

    /**
     * Возвращает модель сущности от аккаунта
     * @param id идентификатор аккаунта
     * @return модель сущности от аккаунта
     */
    @GetMapping(value = "/api/protected/accounts/{id}")
    public EntityModel<Account> one(@PathVariable UUID id) {
        Account account = accountService.getById(id);

        return accountModelAssembler.toModel(account);
    }

    /**
     * Возвращает пустую сущность ответа
     * @param authentication аутентификация
     * @param requestBody тело запроса
     * @return пустую сущность ответа
     */
    @PutMapping(value = "/api/protected/accounts/username")
    public ResponseEntity<?> updateUsername(Authentication authentication, @RequestBody Map<String, String> requestBody) {
        accountService.updateUsername(authentication.getName(), requestBody.get("username"));

        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Возвращает пустую сущность ответа
     * @param authentication аутентификация
     * @param requestBody тело запроса
     * @return пустую сущность ответа
     */
    @PutMapping(value = "/api/protected/accounts/password")
    public ResponseEntity<?> updatePassword(Authentication authentication, @RequestBody Map<String, String> requestBody) {
        accountService.updatePassword(authentication.getName(), requestBody.get("password"));

        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Возвращает пустую сущность ответа
     * @param authentication аутентификация
     * @return пустую сущность ответа
     */
    @DeleteMapping(value = "/api/protected/accounts")
    public ResponseEntity<?> delete(Authentication authentication) {
        accountService.delete(authentication.getName());

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
