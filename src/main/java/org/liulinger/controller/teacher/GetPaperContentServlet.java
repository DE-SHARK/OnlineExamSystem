package org.liulinger.controller.teacher;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.liulinger.Service.Impl.GetExamServiceImpl;

import java.io.IOException;

@WebServlet("/teacher/GetPaperContentServlet")
public class GetPaperContentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("a");
        String stu_id = request.getParameter("stu_id");
        String exam_url = request.getParameter("exam_url");
        int course_id = Integer.parseInt(request.getParameter("course_id"));
        int exam_id = Integer.parseInt(request.getParameter("exam_id"));

        request.getSession().setAttribute("stu_id",stu_id);
        request.getSession().setAttribute("testpaper_url",exam_url);
        request.getSession().setAttribute("course_id",course_id);
        request.getSession().setAttribute("exam_id",exam_id);

        GetExamServiceImpl getExamService = new GetExamServiceImpl();
        String jsondata = getExamService.GetExam(exam_url);

        try {
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(jsondata);

            if (jsonObject.containsKey(stu_id)) {
                response.sendRedirect("StudentExam.jsp");
            } else {
                response.sendRedirect( "GiveGradeServlet?grade=0");
            }
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
