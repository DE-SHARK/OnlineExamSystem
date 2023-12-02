package me.deshark.controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import me.deshark.bean.UserBean;
import me.deshark.dao.UserDao;
import me.deshark.dao.impl.UserDaoImpl;

@WebServlet(name = "RegisterServlet", urlPatterns = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {

        // 获取用户输入的学号、邮箱、姓名和密码
        String uid = req.getParameter("uid");
        String email = req.getParameter("email");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

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
