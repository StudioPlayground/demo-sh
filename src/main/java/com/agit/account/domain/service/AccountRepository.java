package com.agit.account.domain.service;

import com.agit.account.domain.model.aggregates.Account;

import java.util.List;
import java.util.Optional;

public interface AccountRepository {
    Optional<Account> findByCreateAccountId(String createAccountId);
    List<Account> findAll();
    Account save(Account account);
}
