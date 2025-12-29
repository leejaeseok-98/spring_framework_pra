package com.example.shop.user.dto;

import lombok.*;
import org.checkerframework.checker.units.qual.A;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserSessionDto {
    private Long userId;
    private String loginId;
    private String userName;
    private String email;
    private int point;

}
