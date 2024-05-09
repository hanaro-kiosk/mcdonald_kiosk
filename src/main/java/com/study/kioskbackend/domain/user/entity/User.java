package com.study.kioskbackend.domain.user.entity;

import com.study.kioskbackend.domain.admin.dto.UserEditRequestDto;
import com.study.kioskbackend.domain.user.enumeration.UserRole;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
@Getter
@Setter
@Builder
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_idx")
    private Long userIdx;
    @Column(name = "user_id", unique = true, nullable = false)
    private String userId;
    @Column(name = "user_pw", nullable = false)
    private String userPw;
    @Column(name = "user_name", nullable = false)
    private String userName;
    @Column(name = "user_role")
    @Enumerated(EnumType.STRING)
    private UserRole userRole;
    @Column(name = "user_point")
    private int userPoint;
    @Column(name = "user_create_date")
    private LocalDateTime userCreateDate;
    @Column(name = "user_update_date", nullable = true)
    private LocalDateTime userUpdateDate;
    @Column(name = "is_deleted")
    private boolean isDeleted;

    @Builder
    public User(Long userIdx, String userId, String userPw, String userName, UserRole userRole, int userPoint,
                LocalDateTime userCreateDate, LocalDateTime userUpdateDate, boolean isDeleted) {
        this.userIdx = userIdx;
        this.userId = userId;
        this.userPw = userPw;
        this.userName = userName;
        this.userRole = userRole;
        this.userPoint = userPoint;
        this.userCreateDate = userCreateDate;
        this.userUpdateDate = userUpdateDate;
        this.isDeleted = isDeleted;
    }

    public User() {
    }

    public void updatePoint(int point) {
        this.userPoint = point;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //계정의 권한 목록을 리턴함.
        Set<GrantedAuthority> roles = new HashSet<>();
        System.out.println("sssuserRoe>>"+userRole.getValue());
        roles.add(new SimpleGrantedAuthority(userRole.getValue()));
        return roles;
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public String getPassword() {
        return this.userPw;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void editUser(Long userIdx, UserEditRequestDto req) {
        this.userIdx = userIdx;
        this.userId = req.getUserId();
        this.userPw = req.getUserPw();
        this.userName = req.getUserName();
        this.userRole = req.getUserRole();
        this.userPoint = req.getUserPoint();
    }

    public void deleteOrder(Long userIdx) {
        this.userIdx = userIdx;
        this.isDeleted = true;

    }
}