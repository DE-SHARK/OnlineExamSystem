package org.liulinger.controller;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.liulinger.Bean.ExamBean;
import org.liulinger.Dao.ExamListDao;
import org.liulinger.Dao.Impl.ExamListDaoImpl;
import org.liulinger.Service.ExamListService;
import org.liulinger.Service.Impl.ExamListServiceImpl;

import java.io.IOException;
import java.util.List;

@WebServlet("/ExamListServlet")
public class ExamListServlet extends HttpServlet {

    private ExamListService examListService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        //注入依赖
        ExamListDao examListDao = new ExamListDaoImpl();
        this.examListService = new ExamListServiceImpl(examListDao);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int page = 1;
        int recordsPerPage = 3;
        HttpSession session = request.getSession();
        String stu_id =(String) session.getAttribute("stu_id");
        if(request.getParameter("page") != null)
            page = Integer.parseInt(request.getParameter("page"));
        List<ExamBean> list = examListService.getUsersPaginated(page, recordsPerPage, stu_id);
        int noOfRecords = examListService.getNumberOfExam(stu_id);
        int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
        String username = examListService.getUsername(stu_id);
        request.setAttribute("examList", list);
        request.setAttribute("noOfPages", noOfPages);
        request.setAttribute("currentPage", page);
        session.setAttribute("username", username);
        RequestDispatcher view = request.getRequestDispatcher("/student/myExam.jsp");
        view.forward(request, response);
    }
}