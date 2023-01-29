package com.agit.account.interfaces.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateAccountResource {
    @NotBlank(message = "please, Account Name input")
    private String nickName;
    private String birthday;
    private String gender;
    private String profileImage;
    private String purpose;
}
