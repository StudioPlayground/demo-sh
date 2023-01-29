package com.agit.account.infrastructure.repositories.jpa;

import com.agit.account.domain.model.aggregates.Account;
import com.agit.account.domain.service.AccountRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountJPARepository extends AccountRepository, JpaRepository<Account, Long> {
    Optional<Account> findByCreateAccountId(String createAccountId);
    List<Account> findAll();
    Account save(Account account);
}