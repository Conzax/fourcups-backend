package com.conzax.fourcups.controller;

import com.conzax.fourcups.entity.Account;
import com.conzax.fourcups.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AccountController {

    @Autowired
    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping(value = "/accounts")
    public ResponseEntity<?> save(@RequestBody Account account) {
        accountService.save(account);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/accounts")
    public ResponseEntity<List<Account>> get() {
        final List<Account> accounts = accountService.getAll();

        return accounts != null && !accounts.isEmpty()
                ? new ResponseEntity<>(accounts, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/accounts/{nickname}")
    public ResponseEntity<Account> read(@PathVariable(name = "nickname") String nickname) {
        final Account account = accountService.get(nickname);

        return account != null
                ? new ResponseEntity<>(account, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/accounts/{nickname}")
    public ResponseEntity<?> update(@PathVariable(name = "nickname") String nickname, @RequestBody Account update) {
        final Account account = accountService.get(nickname);
        account.setNickname(update.getNickname());
        account.setNickname(update.getNickname());
        account.setEmail(update.getEmail());
        account.setPassword(update.getPassword());

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/accounts/{nickname}")
    public ResponseEntity<?> delete(@PathVariable(name = "nickname") String nickname) {
        accountService.delete(nickname);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
