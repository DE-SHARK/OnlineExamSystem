package me.deshark.controller;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter({"/userPage.jsp", "/adminPage.jpg"})
public class LoginCheckFilter implements Filter {
    @Override
    public void init(FilterConfig config) {
        // 在初始化时执行的操作，通常为空
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        // 获取用户的session
        HttpSession session = httpServletRequest.getSession(false);

        // 检查用户是否已登录
        if (session != null && session.getAttribute("userType") != null) {
            // 用户已登录，继续执行过滤器链
            chain.doFilter(request, response);
        } else {
            // 用户未登录，重定向到登录页面
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/login.jsp");
        }
    }
}
