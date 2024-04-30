package com.study.kioskbackend.domain.user.dto;

//public class JoinRequestDto {
//    private String userId;
//    private String userPw;
//    private String userName;
//
//    public String getUserId() {
//        return userId;
//    }
//
//    public void setUserId(String userId) {
//        this.userId = userId;
//    }
//
//    public String getUserPw() {
//        return userPw;
//    }
//
//    public void setUserPw(String userPw) {
//        this.userPw = userPw;
//    }
//
//    public String getUserName() {
//        return userName;
//    }
//
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }
//}

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