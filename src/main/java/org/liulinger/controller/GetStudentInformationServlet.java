package org.liulinger.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.liulinger.Bean.StudentInformationBean;
import org.liulinger.Dao.Impl.StudentInformationDaoImpl;
import org.liulinger.Dao.StudentInformationDao;
import org.liulinger.Service.Impl.StudentInformationServiceImpl;
import org.liulinger.Service.StudentInformationService;

import java.io.IOException;
import java.util.List;

@WebServlet("/student/GetStudentInformationServlet")
public class GetStudentInformationServlet extends HttpServlet {
    private StudentInformationService studentInformationService;
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        //注入依赖
        StudentInformationDao studentInformationDao = new StudentInformationDaoImpl();
        this.studentInformationService = new StudentInformationServiceImpl(studentInformationDao);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String uid = (String) session.getAttribute("uid");

        if(uid!=null){
            List<StudentInformationBean> list= studentInformationService.getStudentInformationByUid(uid);

            req.setAttribute("list",list);

            RequestDispatcher dispatcher = req.getRequestDispatcher("/student/studentInformation.jsp");
            dispatcher.forward(req, resp);
        }
        else{
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().write("Invalid request: uid is missing.");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
