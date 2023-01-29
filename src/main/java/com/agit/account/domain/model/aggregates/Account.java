package com.agit.account.domain.model.aggregates;

import com.agit.account.domain.model.aggregates.identifiers.CreateAccountId;
import com.agit.account.domain.model.commands.CreateAccountCommand;
import com.agit.account.domain.model.aggregates.valueobjects.AccountBaseInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.AbstractAggregateRoot;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
public class Account extends AbstractAggregateRoot<Account> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private CreateAccountId createAccountId;

    @Embedded
    private AccountBaseInfo accountBaseInfo;

    public Account(CreateAccountCommand createAccountCommand) {
        this.createAccountId = new CreateAccountId(createAccountCommand.getAccountId());
        this.accountBaseInfo = AccountBaseInfo.generateAccountBaseInfo(createAccountCommand);
    }
}