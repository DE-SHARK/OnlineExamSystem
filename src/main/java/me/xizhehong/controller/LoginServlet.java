package me.xizhehong.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import me.xizhehong.Bean.User;
import me.xizhehong.Service.LoginService_impl;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@WebServlet("/xizhehong/LoginServlet")
public class LoginServlet extends HttpServlet {
    public LoginServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String yanzhengma = request.getParameter("yanzhengma");

        LoginService_impl loginServiceImpl = new LoginService_impl();
        User user = loginServiceImpl.login(username, password);

        if (user == null) {
            response.sendRedirect("login.jsp?error=" + URLEncoder.encode("用户名或密码错误", "UTF-8"));
        }
        else {
//            String true_yanzhengma = (String) request.getSession().getAttribute("yanzhengma");
//            if (true_yanzhengma.equals(yanzhengma))


            user.setIf_login("1");
            request.getSession().setAttribute("testCount",user);
            String encodedMessage = URLEncoder.encode(" "+username, StandardCharsets.UTF_8.toString());
            response.sendRedirect("User.jsp?username="+encodedMessage);
//            request.getRequestDispatcher("/User.jsp").forward(request,response);

//            else {
//                response.sendRedirect("login.jsp?error=" + URLEncoder.encode("验证码错误", "UTF-8"));
//            }

//        }
//    }
//}
        }
    }
}