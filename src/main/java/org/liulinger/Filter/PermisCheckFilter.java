package org.liulinger.Filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
@WebFilter("/*")
public class PermisCheckFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        int permission = -1;
       if( ((HttpServletRequest) request).getSession().getAttribute("permission") != null){
           permission =(int) ((HttpServletRequest) request).getSession().getAttribute("permission");
       }
        String requestURI = ((HttpServletRequest) request).getRequestURI();

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        // 获取当前请求的路径
        String path = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());
        //某些页面不进行拦截
        if ("/".equals(path)||"/login.jsp".equals(path) || "/LoginServlet".equals(path) || "/CaptchaImageServlet".equals(path) || "/Register.jsp".equals(path)) {
            chain.doFilter(request, response);
            return;
        }

        // 检查用户权限
        if (permission == 1 && requestURI.startsWith("/student/")) {
            // 用户有 student 权限
            chain.doFilter(request, response);
        } else if (permission == 2 && requestURI.startsWith("/teacher/")) {
            // 用户有 teacher 权限
            chain.doFilter(request, response);
        } else if (permission == 3 && requestURI.startsWith("/admin/")){
            // 管理员权限
            chain.doFilter(request, response);
        }else {
            System.out.println("无权查看");
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {

    }
}
