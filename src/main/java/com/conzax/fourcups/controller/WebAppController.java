package com.conzax.fourcups.controller;

import com.conzax.fourcups.entity.Account;
import com.conzax.fourcups.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Objects;

@Controller
public class WebAppController {

    @Autowired
    private final AccountService accountService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public WebAppController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping(value = "/")
    public String index(Model model) {
        model.addAttribute("message", "message");
        return "index";
    }

    @GetMapping(value = "/signin")
    public String signin(Model model) {
        return "signin";
    }

    @PostMapping(value = "/signin")
    public String signin(String nickname, String password) {
        final Account account = accountService.get(nickname);

        if (account != null) {
            if (passwordEncoder.matches(password, Objects.requireNonNull(account).getPassword())) {
                return "redirect:/account";
            } else {
                return "signin";
            }
        } else {
            return "signin";
        }

    }

    @GetMapping(value = "/signup")
    public String signup(Model model) {
        return "signup";
    }

    @PostMapping(value = "/signup")
    public String signup(Account account) {
        accountService.save(account);

        return "signin";
    }

    @GetMapping(value = "/account")
    public String account(Model model) {
        model.addAttribute("message", "nickname");
        return "account";
    }

}
