package com.conzax.fourcups.repository;

import com.conzax.fourcups.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Repository
@Transactional
public interface AccountRepository extends JpaRepository<Account, UUID> {

    /**
     * Возвращает аккаунт в Optional<> по идентификатору
     * @param id идентификатор аккаунта
     * @return аккаунт в Optional<>
     */
    Optional<Account> findById(UUID id);

    /**
     * Возвращает аккаунт по имени пользователя
     * @param username имя пользователя аккаунта
     * @return акканут
     */
    Account findByUsername(String username);

    /**
     * Удаляет аккаунта по имени пользователя
     * @param username имя пользователя аккаунта
     */
    void deleteByUsername(String username);
}
