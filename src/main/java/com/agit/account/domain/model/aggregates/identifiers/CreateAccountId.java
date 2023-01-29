package com.agit.account.domain.model.aggregates.identifiers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@AllArgsConstructor
@NoArgsConstructor
@Embeddable
@Getter
public class CreateAccountId {
    @Column(name="create_account_id")
    private String createAccountId;
}