package me.deshark.controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import me.deshark.dao.UserDao;
import me.deshark.dao.impl.UserDaoImpl;
import me.deshark.service.AuthenticationService;
import me.deshark.service.impl.AuthenticationServiceImpl;

import javax.swing.text.AttributeSet;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {

    private final AuthenticationService authService = new AuthenticationServiceImpl();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        // 获取用户输入的账号、密码和验证码
        String uid = req.getParameter("uid");
        String password = req.getParameter("password");
        String enteredCaptcha  = req.getParameter("captcha");

        // 获取存储在 session 中的验证码
        HttpSession session = req.getSession();
        String storedCaptcha = (String) session.getAttribute("captcha");

        // 这里可以添加验证验证码的逻辑，确保验证码输入正确
        if (!enteredCaptcha.equals(storedCaptcha)) {
            // 验证码错误，重定向到登录页面并提示错误信息
            resp.sendRedirect(req.getContextPath() + "/login.jsp?error=captcha");
            return;
        }

        if (authService.isValidUser(uid, password)) {
            // 根据权限重定向到相应页面
            int permission = authService.getPermission(uid);
            if (permission == 1) {
                // 为用户 session 设置登录属性
                session.setAttribute("userType", true);
                // 重定向到普通用户页面
                resp.sendRedirect(req.getContextPath() + "/userPage.jsp");
            } else if (permission == 3) {
                // 为用户 session 设置登录属性
                session.setAttribute("userType", true);
                // 重定向到管理员页面
                resp.sendRedirect(req.getContextPath() + "/adminPage.jsp");
            }
        }
    }
}
