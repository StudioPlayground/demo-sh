package com.agit.account.interfaces.rest.transform.mapper;

import com.agit.account.domain.model.commands.CreateAccountCommand;
import com.agit.account.interfaces.rest.dto.CreateAccountResource;
import org.mapstruct.Mapper;

@Mapper
public interface AccountResourceMapper {
    public CreateAccountCommand toCommandFromResource(CreateAccountResource createAccountResource);
}
