package org.liulinger.controller;

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
        String stu_id = "2100502101";
        String exam_url = "C:/Study_Information/git本地仓库/OnlineExamSystem/math_exam.json";
        GetExamServiceImpl getExamService = new GetExamServiceImpl();
        String jsondata = getExamService.GetExam(exam_url);
        try {
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(jsondata);

            if (jsonObject.containsKey(stu_id)) {
                request.getSession().setAttribute("stu_id",stu_id);
                request.getSession().setAttribute("testpaper_url",exam_url);
                response.sendRedirect("StudentExam.jsp");
            } else {
                response.sendRedirect( "ChooseExam.jsp?message=The student missed the exam");
            }
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
