package com.example.shop.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.UUID;

@Controller
public class HomeController {

    @GetMapping("/main")
    public String home(HttpSession session, Model model) {
        // 1. 세션 ID 확인 (브라우저 쿠키와 Redis 키 매칭 확인용)
        String sessionId = session.getId();

        // 2. 세션 데이터 제어: 방문 횟수 카운트 (Redis에 저장/수정됨)
        // 세션에서 값을 꺼내옵니다. (Redis -> Java)
        Integer visitCount = (Integer) session.getAttribute("visitCount");
        
        // 처음 방문이라 값이 없으면 0으로 초기화
        if (visitCount == null) {
            visitCount = 0;
        }
        
        // 방문 횟수 증가
        visitCount++;
        
        // 증가된 값을 다시 세션에 저장 (Java -> Redis)
        session.setAttribute("visitCount", visitCount);

        // 3. 세션 데이터 제어: 사용자 정보 (로그인 시뮬레이션)
        String username = (String) session.getAttribute("username");
        if (username == null) {
            // 없으면 임시 유저 이름 생성해서 저장
            username = "Guest-" + UUID.randomUUID().toString().substring(0, 8);
            session.setAttribute("username", username);
        }

        // 4. 뷰(JSP)에서 볼 수 있도록 모델에 담기
        model.addAttribute("sessionId", sessionId);
        model.addAttribute("visitCount", visitCount);
        model.addAttribute("username", username);

        return "index";
    }

}
