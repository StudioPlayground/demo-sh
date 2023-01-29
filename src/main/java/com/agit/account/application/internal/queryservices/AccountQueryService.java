package com.agit.account.application.internal.queryservices;

import com.agit.account.domain.model.aggregates.Account;
import com.agit.account.domain.service.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountQueryService {

    private final AccountRepository accountRepository;
    
    public Account findByCreateAccountId(String createAccountId) throws Exception {
        Optional<Account> account = accountRepository.findByCreateAccountId(createAccountId);
        if(!account.isEmpty()) {
            return account.get();
        } else {
            throw new Exception("Account is not exist!!");
        }
    }
    
    public List<Account> findAll() {
        return accountRepository.findAll();
    }
}
