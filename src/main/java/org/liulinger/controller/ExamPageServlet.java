package org.liulinger.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Timestamp;

@WebServlet("/ExamPageServlet")
public class ExamPageServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取参数，这里假设你有一个参数来表示考试的编号
        int exam_id = Integer.parseInt(request.getParameter("exam_id"));
        int status = Integer.parseInt(request.getParameter("status"));
        // 获取服务器当前时间
        Timestamp currentTime = new Timestamp(System.currentTimeMillis());

        // 获取考试的开始时间和结束时间
        Timestamp examStartTime = Timestamp.valueOf(request.getParameter("exam_date")); // 假设这里是从数据库获取的考试开始时间
        Timestamp examEndTime = Timestamp.valueOf(request.getParameter("exam_end"));     // 假设这里是从数据库获取的考试结束时间

        // 判断当前时间是否在考试时间范围内
        boolean isWithinTimeLimits = currentTime.after(examStartTime) && currentTime.before(examEndTime);
        // 检查考试是否在允许的时间范围内

        if (status == 0){
            if (isWithinTimeLimits){//考试中
                request.getSession().setAttribute("exam_id",exam_id);
                RequestDispatcher view = request.getRequestDispatcher("/student/examination.jsp");
                view.forward(request, response);
            }else if (currentTime.after(examEndTime)){//缺考
                request.setAttribute("absent", 1);
                RequestDispatcher view = request.getRequestDispatcher("/student/uncompletedExamPage.jsp");
                view.forward(request, response);
            }else {//考试前
                request.setAttribute("absent", 0);
                RequestDispatcher view = request.getRequestDispatcher("/student/uncompletedExamPage.jsp");
                view.forward(request, response);
            }
        }else {//完成考试
            RequestDispatcher view = request.getRequestDispatcher("/student/completedExamPage.jsp");
            view.forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
    }

}
