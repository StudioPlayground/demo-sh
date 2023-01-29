package com.agit.account.domain.model.aggregates.valueobjects;

import com.agit.account.domain.model.commands.CreateAccountCommand;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class AccountBaseInfo {

    @Column(name = "nick_Name", updatable= true)
    private String nickName;
    @Column(name = "birthday", unique = true, updatable= true)
    private String birthday;
    @Column(name = "gender", updatable= true)
    private String gender;
    @Column(name = "profile_image", updatable= true)
    private String profileImage;
    @Column(name = "purpose", updatable= true)
    private String purpose;

    public static AccountBaseInfo generateAccountBaseInfo(CreateAccountCommand createAccountCommand) {
        AccountBaseInfo accountBaseInfo = new AccountBaseInfo();
        accountBaseInfo.setNickName(createAccountCommand.getNickName());
        accountBaseInfo.setBirthday(createAccountCommand.getBirthday());
        accountBaseInfo.setGender(createAccountCommand.getGender());
        accountBaseInfo.setProfileImage(createAccountCommand.getProfileImage());
        accountBaseInfo.setPurpose(createAccountCommand.getPurpose());

        return accountBaseInfo;
    }
}
