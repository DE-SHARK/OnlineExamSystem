package org.liulinger.controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.liulinger.Dao.Impl.UserDaoImpl;
import org.liulinger.Dao.LoginDao;
import org.liulinger.Dao.Impl.LoginDaoImpl;
import org.liulinger.Dao.UserDao;
import org.liulinger.Service.LoginService;
import org.liulinger.Service.Impl.LoginServiceImpl;


import java.io.IOException;

@WebServlet(name = "LoginServ", urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {

    private LoginService loginService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        // 在这里进行依赖注入
        LoginDao loginDao = new LoginDaoImpl();
        UserDao userDao = new UserDaoImpl();
        this.loginService = new LoginServiceImpl(loginDao, userDao);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        // 获取用户输入的账号、密码和验证码
        String uid = req.getParameter("uid");
        String password = req.getParameter("password");
        String enteredCaptcha  = req.getParameter("captcha");

        // 获取存储在 session 中的验证码
        HttpSession session = req.getSession();
        String storedCaptcha = (String) session.getAttribute("captcha");

        // 将账号密码存储到session中
        session.setAttribute("uid",uid);
        session.setAttribute("password",password);



        // 这里可以添加验证验证码的逻辑，确保验证码输入正确
        if (!enteredCaptcha.equalsIgnoreCase(storedCaptcha)) {
            // 当输入验证码为1时，跳过验证码检测
            if (!enteredCaptcha.equals("1")) {
                // 验证码错误，重定向到登录页面并提示错误信息
                resp.sendRedirect(req.getContextPath() + "/login.jsp?error=captcha");
                return;
            }
        }

        // 判定账号密码是否正确
        if (loginService.checkPassword(uid, password)) {
            // 根据权限重定向到相应页面
            int permission = loginService.getPermission(uid);
            req.getSession().setAttribute("permission", permission); //将权限放入session
            session.setAttribute("username",loginService.getUsername(uid));
            if (permission == 1) {
                // 为用户 session 设置登录属性
                session.setAttribute("userType", true);
                session.setAttribute("stu_id",uid);
                // 重定向到学生用户页面
                resp.sendRedirect(req.getContextPath() + "/student/studentPage.jsp");

            } else if (permission == 2) {
                session.setAttribute("userType", true);
                // 重定向到教师用户页面
                resp.sendRedirect(req.getContextPath() + "/teacher/teacherPage.jsp");

            } else if (permission == 3) {
                session.setAttribute("userType", true);
                // 重定向到管理员用户页面
                resp.sendRedirect(req.getContextPath() + "/admin/adminPage.jsp");

            }
        } else {
            // 密码不匹配，登录失败
            resp.getWriter().println("Login failed");
        }
    }

}
