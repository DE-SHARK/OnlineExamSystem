package me.xizhehong.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import me.xizhehong.Service.UserMangeService;
import me.xizhehong.Service.UserMangeService_impl;

import java.io.IOException;
import java.util.List;

@WebServlet("/UserMangeServlet")
public class UserMangeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //请求参数

        //调用服务
        UserMangeService userMangeService = new UserMangeService_impl();
        List list = userMangeService.UserMange();
        //转发回User页面
        req.setAttribute("Student",list);
        req.getRequestDispatcher("StudentManges.jsp").forward(req,resp);
    }
}
