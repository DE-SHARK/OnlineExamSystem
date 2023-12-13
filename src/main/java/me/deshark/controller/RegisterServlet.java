package me.deshark.controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import me.deshark.bean.UserBean;
import me.deshark.dao.UserDao;
import me.deshark.dao.impl.UserDaoImpl;

import java.io.IOException;

import static me.deshark.controller.CheckUsernameServlet.isUsernameAvailable;

@WebServlet(name = "RegisterServlet", urlPatterns = "/deshark/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {

        // 获取用户输入的学号、邮箱、姓名和密码
        String uid = req.getParameter("uid");
        String email = req.getParameter("email");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // 同名用户检查
        if (isUsernameAvailable(username)) {
            try {
                resp.getWriter().write("已存在同名用户，请重新输入。");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return; // 阻止注册
        }

        // 调用 UserBean、UserDaoImpl 向数据库写入用户信息
        UserBean user = new UserBean();
        user.setUid(uid);
        user.setEmail(email);
        user.setUsername(username);
        user.setPassword(password);
        registerUser(user);
    }

    private void registerUser(UserBean user) {
        UserDao userDao = new UserDaoImpl();
        userDao.addUser(user);
    }

}
