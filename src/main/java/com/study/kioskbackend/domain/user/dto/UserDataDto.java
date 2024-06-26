package com.study.kioskbackend.domain.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserDataDto {
    private String accessToken;
    private String userName;
}
