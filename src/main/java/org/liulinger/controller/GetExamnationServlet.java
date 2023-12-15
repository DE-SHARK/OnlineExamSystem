package org.liulinger.controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.liulinger.Service.Impl.GetExamServiceImpl;

import java.io.IOException;

@WebServlet("/GetExamnationServlet")
public class GetExamnationServlet extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获得试卷url
        String url = request.getParameter("examurl");

        if (url != null) {
            // 实例化GetExamServiceImpl对象
            GetExamServiceImpl examService = new GetExamServiceImpl();

            // 调用GetExam方法获取JSON数据
            String jsonData = examService.GetExam(url);

            // 设置响应内容类型为 JSON
            response.setContentType("application/json");

            // 写入 JSON 数据到响应
            response.getWriter().write(jsonData);
        } else {
            // 如果 examUrl 为 null，返回错误响应
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("Invalid request: examurl parameter is missing.");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}