package com.agit.account.domain.model.commands;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;

@Data
public class CreateAccountCommand {

    private String accountId;
    private String accountName;
    private String nickName;
    private String birthday;
    private String gender;
    private String profileImage;
    private String purpose;
}
