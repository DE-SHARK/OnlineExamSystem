package org.liulinger.controller.admin.itemAdd;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.liulinger.Bean.CourseBean;
import org.liulinger.Dao.CourseDao;
import org.liulinger.Dao.Impl.CourseDaoImpl;
import org.liulinger.Service.admin.CourseAddService;
import org.liulinger.Service.admin.impl.CourseAddServiceImpl;

import java.io.IOException;

@WebServlet("/admin/course-add")
public class CourseAddServlet extends HttpServlet {

    private CourseAddService itemAddService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        CourseDao courseDao = new CourseDaoImpl();
        this.itemAddService = new CourseAddServiceImpl(courseDao);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        // 获取用户输入
        CourseBean course = new CourseBean();
        course.setCourseName(req.getParameter("name"));
        course.setMandatory(Boolean.parseBoolean(req.getParameter("mandatory")));

        // 调用 Service 操作
        boolean success = itemAddService.courseAdd(course);

        // 设置成功或失败消息
        String message = success ? "课程添加成功" : "课程添加失败";

        resp.getWriter().write(message);

//        req.getRequestDispatcher("/admin/course-management").forward(req, resp);

    }

}
