package com.conzax.fourcups.controller;

import com.conzax.fourcups.entity.Account;
import com.conzax.fourcups.repository.AccountRepository;
import com.conzax.fourcups.service.AccountService;
import org.apache.catalina.connector.Request;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    public String signin(Model model, RedirectAttributes redirectAttributes, HttpServletRequest request, HttpServletResponse response, String nickname, String password) {
        if (!request.getRemoteAddr().equals("127.0.0.1")) response.setStatus(HttpServletResponse.SC_FORBIDDEN);

        final Account account = accountService.get(nickname);

        if (account != null) {
            if (passwordEncoder.matches(password, Objects.requireNonNull(account).getPassword())) {
                redirectAttributes.addFlashAttribute("nickname", account.getNickname());
                return "redirect:/account";
            } else {
                model.addAttribute("alert", "Wrong password!");
                return "signin";
            }
        } else {
            model.addAttribute("alert", "Account not exists!");
            return "signin";
        }

    }

    @GetMapping(value = "/signup")
    public String signup(Model model) {
        return "signup";
    }

    @PostMapping(value = "/signup")
    public String signup(Model model, RedirectAttributes redirectAttributes, HttpServletRequest request, HttpServletResponse response, Account account) {
        if (!request.getRemoteAddr().equals("127.0.0.1")) response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        if (accountService.get(account.getNickname()) != null) {
            redirectAttributes.addFlashAttribute("alert", "Account already exists!");
            return "redirect:/signup";
        }

        accountService.save(account);

        model.addAttribute("alert", "You are the " + account.getId() + ending(account.getId()) + " user!");
        return "signup";
    }

    @GetMapping(value = "/account")
    public String account(Model model) {
        if (model.getAttribute("nickname") == null) return "redirect:/signin";
        return "account";
    }

    private static String ending(long number) {
        long tenMod = number % 10;
        long hunMod = number % 100;

        if (hunMod - tenMod == 10) return "th";
        return switch ((int) tenMod) {
            case 1 -> "st";
            case 2 -> "nd";
            case 3 -> "rd";
            default -> "th";
        };
    }

}
