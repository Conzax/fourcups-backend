package com.conzax.fourcups.service;

import com.conzax.fourcups.entity.Account;
import com.conzax.fourcups.exception.AccountAlreadyExistsException;
import com.conzax.fourcups.exception.AccountNotFoundException;
import com.conzax.fourcups.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * Возвращает список существующих аккаунтов
     * @return список аккаунтов
     */
    public List<Account> getAll() {
        return accountRepository.findAll();
    }

    /**
     * Создает новый аккаунт
     * @param account аккаунт к создания
     * @return созданный аккаунт
     */
    public Account create(Account account) {
        if (accountRepository.findByUsername(account.getUsername()) != null)
            throw new AccountAlreadyExistsException(account.getUsername());

        account.setPassword(passwordEncoder.encode(account.getPassword()));
        return accountRepository.save(account);
    }

    /**
     * Возвращает аккаунт по идентификатору
     * @param id идентификатор аккаунта
     * @return аккаунт
     */
    public Account getById(UUID id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException(id));
    }

    /**
     * Возвращает аккаунт по имени пользователя
     * @param username имя пользователя аккаунта
     * @return аккаунт
     */
    public Account getByUsername(String username) {
        return accountRepository.findByUsername(username);
    }

    /**
     * Обновляет имя пользователя аккаунта
     * @param username имя пользователя аккаунта
     * @param update обновление(новое имя пользователя)
     */
    public void updateUsername(String username, String update) {
        Account account = accountRepository.findByUsername(username);
        account.setUsername(update);
        accountRepository.save(account);
    }

    /**
     * Обновляет пароль
     * @param username имя пользователя аккаунта
     * @param update обновление(новый пароль)
     */
    public void updatePassword(String username, String update) {
        Account account = accountRepository.findByUsername(username);
        account.setPassword(passwordEncoder.encode(update));
        accountRepository.save(account);
    }

    /**
     * Удаляет аккаунт по имени пользователя
     * @param username имя пользователя аккаунта
     */
    public void delete(String username) {
        accountRepository.deleteByUsername(username);
    }
}
