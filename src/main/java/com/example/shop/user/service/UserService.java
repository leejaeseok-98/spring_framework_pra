package com.example.shop.user.service;

import com.example.shop.order.domain.OrderVo;
import com.example.shop.user.domain.UserVo;
import com.example.shop.user.dto.UserSessionDto;
import com.example.shop.user.dto.req.UserLoginReqDto;
import com.example.shop.user.dto.res.UserLoginResDto;
import com.example.shop.user.mapper.user.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    UserVo getUserInfo(Long userId);
    UserSessionDto login(UserLoginReqDto loginReqDto);

    UserSessionDto getUserSessionInfoByUserId(Long userId);

}
