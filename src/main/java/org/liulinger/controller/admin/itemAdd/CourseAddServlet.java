package org.liulinger.controller.admin.itemAdd;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.liulinger.Bean.CourseBean;
import org.liulinger.Dao.admin.CourseDao;
import org.liulinger.Dao.admin.impl.CourseDaoImpl;
import org.liulinger.Service.admin.ItemAddService;
import org.liulinger.Service.admin.impl.CourseAddServiceImpl;

import java.io.IOException;

@WebServlet("/admin/course-add")
public class CourseAddServlet extends UserAddServlet<CourseBean> {

    @Override
    protected ItemAddService<CourseBean> createItemAddService() {
        CourseDao courseDao = new CourseDaoImpl();
        return new CourseAddServiceImpl(courseDao);
    }

    @Override
    void handleRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 获取用户输入
        CourseBean course = new CourseBean();
        course.setCourseName(req.getParameter("name"));
        course.setMandatory(Boolean.parseBoolean(req.getParameter("mandatory")));

        // 调用 Service 操作
        boolean success = getItemAddService().addItem(course);

        // 设置成功或失败消息
        String message = success ? "课程添加成功" : "课程添加失败";

        resp.getWriter().write(message);
    }

}
