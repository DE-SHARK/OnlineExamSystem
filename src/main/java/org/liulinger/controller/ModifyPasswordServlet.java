package org.liulinger.controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/student/ModifyPasswordServlet")
public class ModifyPasswordServlet extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String oldPassword = (String) session.getAttribute("password");

        String currentPassword = req.getParameter("currentPassword");
        String newPassword = req.getParameter("newPassword");

        if(currentPassword.equals(oldPassword)){
            System.out.println("success");

            resp.sendRedirect("login.jsp");
        }else {
            // 原密码不匹配，显示错误消息并要求重试
            String errorMessage = "原密码输入错误，请重试";
            req.setAttribute("errorMessage", errorMessage);
            req.getRequestDispatcher("ModifyPassword.jsp").forward(req, resp);
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
