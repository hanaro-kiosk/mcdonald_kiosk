package com.study.kioskbackend.domain.user.dto;

import com.study.kioskbackend.domain.user.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LoginRequestDto {
    private String userId;
    private String userPw;

    public User toSaveEntity() {
        return User.builder()
                .userId(userId)
                .userPw(userPw)
                .build();
    }

}
