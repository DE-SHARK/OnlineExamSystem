package me.xizhehong.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import me.xizhehong.Service.RegisterService_impl;
import org.mindrot.jbcrypt.BCrypt;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String password1 = req.getParameter("password1");
        //验证注册账户合法性
        String answer = new RegisterService_impl().Count_Legality(username,password,password1);
        System.out.println(answer);
        if (!"注册成功".equals(answer)){
//            resp.sendRedirect("Register.jsp?error=" + URLEncoder.encode(""+answer, "UTF-8")+answer);
            String encodedMessage = URLEncoder.encode(" "+answer, StandardCharsets.UTF_8.toString());
            resp.sendRedirect("Register.jsp?error="+encodedMessage);
        }
        else {
            //加密密码
            String salt = BCrypt.gensalt();
            String hashedPassword = BCrypt.hashpw(password, salt);
            //写入数据库
            new RegisterService_impl().Register(username, hashedPassword,"0");
//            resp.sendRedirect("Login.jsp?error=注册成功");
            String encodedMessage = URLEncoder.encode(" "+answer, StandardCharsets.UTF_8.toString());
            resp.sendRedirect("Login.jsp?error="+encodedMessage);
        }
    }
}
