package org.liulinger.controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.liulinger.Dao.Impl.StudentInformationDaoImpl;
import org.liulinger.Dao.StudentInformationDao;
import org.liulinger.Service.Impl.StudentInformationServiceImpl;
import org.liulinger.Service.StudentInformationService;

import java.io.IOException;

@WebServlet("/ModifyPasswordServlet")
public class ModifyPasswordServlet extends HttpServlet {
    private StudentInformationService studentInformationService;
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        //注入依赖
        StudentInformationDao studentInformationDao = new StudentInformationDaoImpl();
        this.studentInformationService = new StudentInformationServiceImpl(studentInformationDao);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int flag=0;//密码是否修改成功

        HttpSession session = req.getSession();
        String uid = (String) session.getAttribute("uid");
        String oldPassword = (String) session.getAttribute("password");

        String currentPassword = req.getParameter("currentPassword");
        String newPassword = req.getParameter("newPassword");

        if(currentPassword.equals(oldPassword)){
            studentInformationService.updatePassword(uid,newPassword);
            // 原密码匹配，且修改的密码符合规范，修改成功，即将跳转到登陆页面
            String rightMessage = "修改成功，即将跳转到登陆页面";
            req.setAttribute("rightMessage", rightMessage);
            req.getRequestDispatcher("/student/ModifyPassword.jsp").forward(req, resp);
            flag = 1;
        }else {
            // 原密码不匹配，显示错误消息并要求重试
            String errorMessage = "原密码输入错误，请重试";
            req.setAttribute("errorMessage", errorMessage);
            req.getRequestDispatcher("/student/ModifyPassword.jsp").forward(req, resp);
        }

        if(flag==1){
            resp.sendRedirect("login.jsp");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
