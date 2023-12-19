package org.liulinger.controller.student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.liulinger.Bean.GradeBean;
import org.liulinger.Service.GetStudentGradeService;
import org.liulinger.Service.Impl.GetStudentGradeServiceImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/student/GetStudentGradeServlet")
public class GetStudentGradeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String stu_id = (String) request.getSession().getAttribute("stu_id");
        //调用方法，获得成绩列表
        List<GradeBean> list = new ArrayList<>();
        GetStudentGradeService getStudentGradeService = new GetStudentGradeServiceImpl();
        list = getStudentGradeService.GetSTudentGrade(stu_id);
        request.getSession().setAttribute("StudentGrade",list);
        response.sendRedirect("StudentGrade.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
