package com.example.shop.user.service;

import com.example.shop.order.domain.OrderVo;
import com.example.shop.user.domain.UserVo;
import com.example.shop.user.dto.UserSessionDto;
import com.example.shop.user.dto.req.UserCreateReqDto;
import com.example.shop.user.dto.req.UserLoginReqDto;
import com.example.shop.user.dto.res.UserLoginResDto;
import com.example.shop.user.mapper.order.OrderMapper;
import com.example.shop.user.mapper.user.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserVo getUserInfo(Long userId) {

        UserVo user = userMapper.getUser(userId).orElseThrow(() -> new IllegalArgumentException("아이디 또는 비밀번호가 일치하지 않습니다."));
        return user;
    }

    public void create(UserCreateReqDto createReqDto) {
        String encodePw = passwordEncoder.encode(createReqDto.getUserPw());
        UserVo user = createReqDto.toEntity(encodePw);
        userMapper.create(user);
    }

    @Override
    public UserSessionDto getUserSessionInfoByUserId(Long userId) {
        return userMapper.getUserSessionInfoByUserId(userId);
    }

    public UserSessionDto login(UserLoginReqDto loginDto) {

        String loginId = loginDto.getLoginId();
        String userPw = loginDto.getUserPw();

        UserVo user = userMapper.getUserByLoginId(loginDto.getLoginId())
                .orElseThrow(() -> new IllegalArgumentException("아이디 또는 비밀번호가 일치하지 않습니다."));

        // 2. 비밀번호 일치 여부 확인
        // loginDto.getUserPw()는 String이어야 함
        if (!passwordEncoder.matches(loginDto.getUserPw(), user.getUserPw())) {
            throw new IllegalArgumentException("아이디 또는 비밀번호가 일치하지 않습니다.");
        }

        // 3. UserVo를 UserSessionDto로 변환하여 반환 (민감정보 제외)
        return UserSessionDto.builder()
                .userId(user.getUserId())
                .userName(user.getUserName())
                .loginId(user.getLoginId())
                .point(user.getPoint())
                .email(user.getEmail())
                .build();
    }
}
