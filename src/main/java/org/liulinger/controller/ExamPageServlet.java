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

@WebServlet("/student/ExamPageServlet")
public class ExamPageServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int status = Integer.parseInt(request.getParameter("status"));
        // 获取服务器当前时间
        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
        // 获取考试的开始时间和结束时间
        Timestamp examStartTime = Timestamp.valueOf(request.getParameter("exam_date"));
        Timestamp examEndTime = Timestamp.valueOf(request.getParameter("exam_end"));
        // 判断当前时间是否在考试时间范围内
        boolean isWithinTimeLimits = currentTime.after(examStartTime) && currentTime.before(examEndTime);
        // 检查考试是否在允许的时间范围内
        if (status == 0){
            if (isWithinTimeLimits){//考试中
                int exam_id = Integer.parseInt(request.getParameter("exam_id"));
                request.getSession().setAttribute("exam_id",exam_id);
                String testpaper_url = request.getParameter("testpaper_url");
                request.getSession().setAttribute("testpaper_url",testpaper_url);
                int course_id = Integer.parseInt(request.getParameter("course_id"));
                request.getSession().setAttribute("course_id",course_id);

                RequestDispatcher view = request.getRequestDispatcher("/student/examination.jsp");
                view.forward(request, response);
            }else if (currentTime.after(examEndTime)){//缺考
                request.setAttribute("absent", 1);
                request.setAttribute("examStartTime", examStartTime);
                request.setAttribute("examEndTime", examEndTime);
                RequestDispatcher view = request.getRequestDispatcher("/student/uncompletedExamPage.jsp");
                view.forward(request, response);
            }else {//考试前
                request.setAttribute("absent", 0);
                request.setAttribute("examStartTime", examStartTime);
                request.setAttribute("examEndTime", examEndTime);
                RequestDispatcher view = request.getRequestDispatcher("/student/uncompletedExamPage.jsp");
                view.forward(request, response);
            }
        }else {//完成考试
            double score = Double.parseDouble(request.getParameter("score"));
            request.setAttribute("score", score);
            request.setAttribute("examStartTime", examStartTime);
            request.setAttribute("examEndTime", examEndTime);
            RequestDispatcher view = request.getRequestDispatcher("/student/completedExamPage.jsp");
            view.forward(request, response);
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
    }

}
