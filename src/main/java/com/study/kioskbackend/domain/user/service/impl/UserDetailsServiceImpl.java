package com.study.kioskbackend.domain.user.service.impl;

import com.study.kioskbackend.domain.user.repository.UserRepository;
import com.study.kioskbackend.domain.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
@Primary
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        User userEntity = userRepository.findByUserId(userId)
                .orElseThrow(() -> new UsernameNotFoundException("아이디에 맞는 회원 정보를 찾을 수 없습니다."));

        // User 엔티티에서 UserDetails를 생성하여 반환
        return org.springframework.security.core.userdetails.User.builder()
                .username(userEntity.getUserId())
                .password(userEntity.getUserPw())
                .roles(userEntity.getUserRole().toString()) // 또는 authorities() 메서드를 사용하여 권한을 설정할 수 있습니다.
                .build();
    }
}
