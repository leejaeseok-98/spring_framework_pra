package com.example.shop.user.controller;

import com.example.shop.order.service.OrderService;
import com.example.shop.user.dto.UserSessionDto;
import com.example.shop.user.dto.req.UserCreateReqDto;
import com.example.shop.user.dto.req.UserLoginReqDto;
import com.example.shop.user.service.UserService;
import com.example.shop.user.service.UserServiceImpl;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserServiceImpl userServiceImpl;
    private final OrderService orderService;

    @GetMapping("/mypage")
    public String myPage(Long userId, Model model) {

        // 1. 사용자 정보 조회
        model.addAttribute("user", userService.getUserInfo(userId));
        // 2. 최근 주문 내역 조회
        model.addAttribute("orderList", orderService.getRecentOrders(userId));

        return "user/myPage"; // /WEB-INF/views/user/myPage.jsp
    }

    // 회원가입 페이지 이동 (GET)
    @GetMapping("/join")
    public String joinForm() {
        return "user/join"; // /WEB-INF/views/user/join.jsp 로 이동
    }

    @PostMapping("/join")
    public String create(UserCreateReqDto createReqDto, RedirectAttributes rttr){
        userServiceImpl.create(createReqDto);
        rttr.addFlashAttribute("msg", "회원가입이 완료되었습니다.");
        return "redirect:/user/login";
    }

    // 로그인 페이지로 이동
    @GetMapping("/login")
    public String loginForm() {
        return "user/login"; // user/login.jsp
    }

    @PostMapping("/login")
    public String login(UserLoginReqDto loginDto, HttpSession session, RedirectAttributes rttr) {
        try {
            // 1. 서비스 호출 (예외 발생 가능)
            UserSessionDto user = userService.login(loginDto);

            // 2. 성공 시 세션 저장 후 메인 이동
            session.setAttribute("userId", user.getUserId());
            session.setAttribute("loginId", user.getLoginId());
            session.setAttribute("userName", user.getUserName());
            session.setAttribute("email", user.getEmail());

            return "redirect:/";

        } catch (IllegalArgumentException e) {
            // 3. 예외 발생 시 (ID/PW 불일치 등)
            // RedirectAttributes를 사용하여 에러 메시지를 일회성으로 전달
            rttr.addFlashAttribute("msg", e.getMessage());

            // 4. 로그인 페이지로 리다이렉트
            return "redirect:/user/login";
        }
    }
}
