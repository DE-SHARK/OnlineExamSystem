package org.liulinger.Filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter("/*")
public class LoginCheckFilter implements Filter {
    private static final String[] ALLOWED_EXTENSIONS = {"CourseManagement.css", ".png", ".jpg", ".jpeg", ".gif"};
    @Override
    public void init(FilterConfig filterConfig) {
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        // 获取当前请求的路径
        String path = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());
        //某些页面不进行拦截
        if ("/".equals(path) || "/login.jsp".equals(path) || "/LoginServlet".equals(path)
                || "/CaptchaImageServlet".equals(path) || "/Register.jsp".equals(path) || isAllowedExtension(path)) {
            chain.doFilter(request, response);
            return;
        }
        // 对其他请求进行登陆态检查
        HttpSession session = httpRequest.getSession(false);
        if (session == null || session.getAttribute("userType") == null || !session.getAttribute("userType").equals(true)) {
            // 用户未登录，强制跳转到登录页面
//            ((HttpServletResponse) response).sendRedirect(httpRequest.getContextPath() + "/login.jsp");
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().write("<script>alert('请先进行登录,正在跳转...');setTimeout(function(){window.location.href='/login.jsp';},1);</script>");
        } else {
            // 用户已登录，继续执行过滤器链
            chain.doFilter(request, response);
        }
    }
    @Override
    public void destroy() {
    }
    private boolean isAllowedExtension(String path) {
        for (String extension : ALLOWED_EXTENSIONS) {
            if (path.endsWith(extension)) {
                return true;
            }
        }
        return false;
    }
}