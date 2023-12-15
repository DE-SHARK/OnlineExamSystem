package org.liulinger.controller;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.liulinger.Bean.ExamBean;
import org.liulinger.Dao.ExamListDaoImpl;


import java.io.IOException;
import java.util.List;

@WebServlet("/ExamListServlet")
public class ExamListServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int page = 1;
        int recordsPerPage = 5;
        String stu_id = request.getParameter("stu_id");
        if(request.getParameter("page") != null)
            page = Integer.parseInt(request.getParameter("page"));
        ExamListDaoImpl examListDao = new ExamListDaoImpl();
        List<ExamBean> list = examListDao.getUsersPaginated(page, recordsPerPage, stu_id);
        int noOfRecords = examListDao.getNumberOfExam(stu_id);
        int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
        request.setAttribute("examList", list);
        request.setAttribute("noOfPages", noOfPages);
        request.setAttribute("currentPage", page);
        RequestDispatcher view = request.getRequestDispatcher("/studentPage.jsp?stu_id="+stu_id);
        view.forward(request, response);
    }
}