package com.example.shop.user.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import java.util.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserVo {
    private Long userId;
    @NonNull
    private String loginId;
    @NonNull
    private String userPw;
    @NonNull
    private String userName;
    @NonNull
    private String email;
    private int point;
    private Date regDate;


    @Override
    public String toString() {
        return "UserVO [userId=" + userId + ", userName=" + userName + ", point=" + point + "]";
    }
}
