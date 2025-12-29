package com.example.shop.common.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
        // 1. 세션에서 로그인 정보 가져오기
        HttpSession session = request.getSession();
        Object loginUser = session.getAttribute("loginUser");

        if (loginUser == null) {
            // 2. 로그인 정보가 없으면 로그인 페이지로 리다이렉트
            String contextPath = request.getContextPath();
            response.sendRedirect(contextPath + "/user/login");
            return false; // 컨트롤러로 요청을 전달하지 않음
        }

        // 3. 로그인 되어 있으면 그대로 컨트롤러 진행
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }
}

