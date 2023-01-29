package com.agit.account.application.internal.commandservices;

import com.agit.account.domain.model.aggregates.identifiers.CreateAccountId;
import com.agit.account.domain.model.commands.CreateAccountCommand;
import com.agit.account.domain.model.aggregates.Account;
import com.agit.account.domain.service.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountCommandService {

    private final AccountRepository accountRepository;

    public CreateAccountId createAccount(CreateAccountCommand createAccountCommand) {
        String random = UUID.randomUUID().toString().toUpperCase();
        createAccountCommand.setAccountId(random.substring(0, random.indexOf("-")));
        Account account = new Account(createAccountCommand);
        accountRepository.save(account);
        return new CreateAccountId(random);
    }
}
