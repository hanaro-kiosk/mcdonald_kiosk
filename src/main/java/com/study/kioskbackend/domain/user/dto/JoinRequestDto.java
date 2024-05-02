package com.study.kioskbackend.domain.user.dto;

import com.study.kioskbackend.domain.user.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class JoinRequestDto {
    private String userId;
    private String userPw;
    private String userName;

    public User toSaveEntity() {
        return User.builder()
                .userId(userId)
                .userPw(userPw)
                .userName(userName)
                .build();
    }

}