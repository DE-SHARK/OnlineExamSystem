package org.liulinger.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.liulinger.Service.GetExamService;
import org.liulinger.Service.Impl.GetExamServiceImpl;

import java.io.FileWriter;
import java.io.IOException;

@WebServlet("/SendStudentAnswerServlet")
public class SendStudentAnswerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException {
        int questionsLength = Integer.parseInt(request.getParameter("questionsLength"));
        //创建一个json对象存储单选框的值
        org.json.simple.JSONObject answersObject = new org.json.simple.JSONObject();

        // 取出单选框的值
        for (int i = 0; i < questionsLength; i++) {
            String selectedValue = request.getParameter("answer_" + i);
            answersObject.put("answer" + i, selectedValue);
        }

        try {
            String filePath = (String) request.getSession().getAttribute("testpaper_url");
            GetExamService getExamService = new GetExamServiceImpl();
            String exam = getExamService.GetExam(filePath);
            JSONParser jsonParser = new JSONParser();
            org.json.simple.JSONObject jsonObject = (org.json.simple.JSONObject) jsonParser.parse(exam);
            // 将答案json存入原json中
            String stu_id = (String) request.getSession().getAttribute("stu_id");
            jsonObject.put(stu_id, answersObject);
            //将合并后的json写回原地址
            FileWriter writer = new FileWriter(filePath);
            writer.write(jsonObject.toString());
            writer.close();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }
}



