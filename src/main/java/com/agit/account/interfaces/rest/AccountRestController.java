package com.agit.account.interfaces.rest;

import com.agit.account.application.internal.commandservices.AccountCommandService;
import com.agit.account.application.internal.queryservices.AccountQueryService;
import com.agit.account.domain.model.aggregates.identifiers.CreateAccountId;
import com.agit.account.domain.model.aggregates.Account;
import com.agit.account.interfaces.rest.dto.CreateAccountResource;
import com.agit.account.interfaces.rest.transform.mapper.AccountResourceMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AccountRestController {

    private final AccountCommandService accountCommandService;
    private final AccountQueryService accountQueryService;
    private final AccountResourceMapper accountResourceMapper;

    @PostMapping("/account")
    public ResponseEntity<CreateAccountId> createAccount(@Valid @RequestBody CreateAccountResource createAccountResource) {
        CreateAccountId createAccountId = accountCommandService.createAccount(
                accountResourceMapper.toCommandFromResource(createAccountResource));
        final URI uri =
            MvcUriComponentsBuilder.fromController(getClass())
            .path("/{id}")
            .buildAndExpand(createAccountId.getCreateAccountId())
            .toUri();
        return ResponseEntity.created(uri).body(createAccountId);
    }

    @GetMapping("/account")
    public Account findByCreateAccountId(@RequestParam String createAccountId) throws Exception {
        return accountQueryService.findByCreateAccountId(createAccountId);
    }

    @GetMapping("/accounts")
    public List<Account> getAllAccounts() {
        return accountQueryService.findAll();
    }

    @PutMapping("/account")
    public String updateAccount() {
        return "accounts";
    }

    @DeleteMapping("/account/{accountId}")
    public String deleteAccount(@PathVariable String accountId) {
        return "accounts";
    }
}