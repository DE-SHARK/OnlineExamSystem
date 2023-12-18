package org.liulinger.controller.admin.management.teacher;

import jakarta.servlet.annotation.WebServlet;
import org.liulinger.Bean.UserBean;
import org.liulinger.Dao.Impl.UserDaoImpl;
import org.liulinger.Dao.UserDao;
import org.liulinger.Service.admin.ItemListService;
import org.liulinger.Service.admin.impl.TeacherListServiceImpl;
import org.liulinger.controller.admin.management.ItemListServlet;

@WebServlet("/admin/teacher-list")
public class TeacherListServlet extends ItemListServlet<UserBean> {

    @Override
    protected ItemListService<UserBean> createItemListService() {
        UserDao userDao = new UserDaoImpl();
        return new TeacherListServiceImpl(userDao);
    }

    @Override
    protected String getManagementPage() {
        return "/admin/teacherManagement.jsp";
    }
}
