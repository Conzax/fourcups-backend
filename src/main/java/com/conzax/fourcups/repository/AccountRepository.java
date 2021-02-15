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

    Optional<Account> findById(UUID id);
    Account findByUsername(String username);
    void deleteByUsername(String username);
}
