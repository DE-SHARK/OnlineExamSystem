package org.liulinger.controller.teacher;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.liulinger.Service.ChangeExamStausService;
import org.liulinger.Service.Impl.ChangeExamStausServiceImpl;

import java.io.IOException;

@WebServlet("/teacher/GiveGradeServlet")
public class GiveGradeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double grade = Double.parseDouble(request.getParameter("grade"));
        String stu_id = (String) request.getSession().getAttribute("stu_id");
        int course_id = (int) request.getSession().getAttribute("course_id");
        int exam_id = (int) request.getSession().getAttribute("exam_id");
        ChangeExamStausService changeExamStausService = new ChangeExamStausServiceImpl();
        String result = changeExamStausService.ChangeExamStaus(stu_id, course_id, exam_id, grade);
        if (grade != 0) {
            response.sendRedirect("ChooseExam.jsp?message=" + result);
        }
        else {
            response.sendRedirect("ChooseExam.jsp?message=The Student is missing exam");
        }
    }
}
