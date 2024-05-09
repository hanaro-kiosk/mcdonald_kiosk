package com.study.kioskbackend.domain.admin.dto;

import com.study.kioskbackend.domain.user.enumeration.UserRole;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserEditRequestDto {
    private String userId;
    private String userPw;
    private String userName;
    private UserRole userRole;
    private int userPoint;
}
