package me.xizhehong.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import me.xizhehong.Service.RegisterService;
import me.xizhehong.Service.RegisterService_impl;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/xizhehong/Checkusername")
public class Checkusername_Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        RegisterService registerServiceImpl = new RegisterService_impl();
        String answer = registerServiceImpl.Username_repeat(username);
        PrintWriter out = resp.getWriter();
        if ("yes".equals(answer)){
            out.println("名称可用");
        }
        else {
            out.println("名称已被占用");
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
