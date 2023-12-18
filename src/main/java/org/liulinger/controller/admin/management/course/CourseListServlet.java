package org.liulinger.controller.admin.management.course;

import jakarta.servlet.annotation.WebServlet;
import org.liulinger.Bean.CourseBean;
import org.liulinger.Dao.admin.CourseDao;
import org.liulinger.Dao.admin.impl.CourseDaoImpl;
import org.liulinger.Service.admin.ItemListService;
import org.liulinger.Service.admin.impl.CourseListServiceImpl;
import org.liulinger.controller.admin.management.ItemListServlet;

@WebServlet("/admin/course-list")
public class CourseListServlet extends ItemListServlet<CourseBean> {

    @Override
    protected ItemListService<CourseBean> createItemListService() {
        CourseDao courseDao = new CourseDaoImpl();
        return new CourseListServiceImpl(courseDao);
    }

    @Override
    protected String getManagementPage() {
        return "/admin/courseManagement.jsp";
    }
}
