package org.liulinger.controller.teacher;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.liulinger.Bean.ChooseExamBean;
import org.liulinger.Dao.Impl.ChooseExamDaoImpl;
import org.liulinger.Service.ChooseExamService;
import org.liulinger.Service.Impl.ChooseExamServiceImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/teacher/ChooseExamServlet")
public class ChooseExamServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //选择页面需要的参数:teacher.id(即session中的stu_id),course_id,
        //需要呈现的参数，course_name,stu_id,exam_url11
        //需求： 选择课程，返回课程对应的所有试卷
        //teacherClass.class_id=classCourse.class_id and classCourse.course_id=exams.course_id and exams.course_id=grades.course_id
        //1.调用方法返回list
        List<ChooseExamBean> examlist = new ArrayList<>();
        ChooseExamService chooseExamService = new ChooseExamServiceImpl(new ChooseExamDaoImpl());
        String teacher_id = (String) request.getSession().getAttribute("teacher_id");
        String course_name = request.getParameter("course_name");
        examlist =  chooseExamService.ChooseExam(course_name,teacher_id);
        request.getSession().setAttribute("examlist",examlist);
        response.sendRedirect("ChooseExam.jsp");
    }
}
