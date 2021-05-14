package com.conzax.fourcups.controller;

import com.conzax.fourcups.entity.Account;
import com.conzax.fourcups.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
public class AccountController {

    @Autowired
    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping(value = "/api/public/accounts")
    public ResponseEntity<?> create(@RequestBody Account account) {
        accountService.create(account);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/api/secured/accounts")
    public ResponseEntity<List<Account>> all() {
        final List<Account> accounts = accountService.getAll();

        return accounts != null && !accounts.isEmpty()
                ? new ResponseEntity<>(accounts, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/api/secured/accounts/{id}")
    public ResponseEntity<Account> one(@PathVariable UUID id) {
        final Account account = accountService.getById(id);

        return account != null
                ? new ResponseEntity<>(account, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/api/secured/accounts/username")
    public ResponseEntity<?> updateUsername(Authentication authentication,
                                            @RequestBody Map<String, String> requestBody) {
        accountService.updateUsername(authentication.getName(), requestBody.get("username"));

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/api/secured/accounts/password")
    public ResponseEntity<?> updatePassword(Authentication authentication,
                                            @RequestBody Map<String, String> requestBody) {
        accountService.updatePassword(authentication.getName(), requestBody.get("password"));

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/api/secured/accounts")
    public ResponseEntity<?> delete(Authentication authentication) {
        accountService.delete(authentication.getName());

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
