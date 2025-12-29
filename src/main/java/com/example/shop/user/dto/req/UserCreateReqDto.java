package com.example.shop.user.dto.req;

import com.example.shop.user.domain.UserVo;
import lombok.*;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserCreateReqDto {
    private String loginId;
    private String userPw;
    private String userName;
    private String email;

    public UserVo toEntity(String encodePassword){
        return UserVo.builder()
                .loginId(this.loginId)
                .userPw(encodePassword)
                .userName(this.userName)
                .email(this.email)
                .point(0)
                .build();
    }
}
