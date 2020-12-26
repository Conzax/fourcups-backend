package com.conzax.fourcups.service;

import com.conzax.fourcups.entity.Account;
import com.conzax.fourcups.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<Account> getAll() {
        return accountRepository.findAll();
    }

    public void save(Account account) {
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        accountRepository.save(account);
    }

    public Account get(String nickname) {
        return accountRepository.findByNickname(nickname);
    }

    public void update(String Nickname, Account account) {}

    public void delete(String nickname) {
        accountRepository.deleteByNickname(nickname);
    }

}
