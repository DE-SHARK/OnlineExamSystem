package me.xizhehong.Filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import me.xizhehong.Bean.User;

import java.io.IOException;

@WebFilter("/User.jsp")
public class LoginCheckFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //将request类进行转换， HttpServletRequest类有更多关于http的方法如session
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        User user = (User) request.getSession().getAttribute("testCount");
        if (user == null){
            response.sendRedirect("Login.jsp");
        }
        else {
            filterChain.doFilter(servletRequest, servletResponse);
        }

    }
}
