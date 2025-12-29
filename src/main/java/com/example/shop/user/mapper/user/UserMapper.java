package com.example.shop.user.mapper.user;

import com.example.shop.user.domain.UserVo;
import com.example.shop.user.dto.req.UserCreateReqDto;
import com.example.shop.user.dto.res.UserLoginResDto;
import com.example.shop.user.dto.UserSessionDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface UserMapper {
    Optional<UserVo> getUser(Long userId);
    Optional<UserVo> getUserByLoginId(String  loginId);
    UserSessionDto getUserSessionInfoByUserId(Long userId);
    void create(UserVo user);
    UserLoginResDto findByLoginId(String loginId);


}
