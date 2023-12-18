package org.liulinger.controller.student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.liulinger.Service.GetExamService;
import org.liulinger.Service.Impl.GetExamServiceImpl;

import java.io.IOException;

@WebServlet("/teacher/StudentExamServlet")
public class StudentExamServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String stu_id = request.getParameter("stu_id");
        String exam_url = request.getParameter("exam_url");
        GetExamService getExamService = new GetExamServiceImpl();
        String exam = getExamService.GetExam(exam_url);
        response.setContentType("application/json");
        response.getWriter().write(exam);
    }
}
