package org.liulinger.controller.admin.management.student;

import jakarta.servlet.annotation.WebServlet;
import org.liulinger.Bean.UserBean;
import org.liulinger.Dao.Impl.UserDaoImpl;
import org.liulinger.Dao.UserDao;
import org.liulinger.Service.admin.ItemListService;
import org.liulinger.Service.admin.impl.StudentListServiceImpl;
import org.liulinger.controller.admin.management.ItemListServlet;

@WebServlet("/admin/student-list")
public class StudentListServlet extends ItemListServlet<UserBean> {

    @Override
    protected ItemListService<UserBean> createItemListService() {
        UserDao userDao = new UserDaoImpl();
        return new StudentListServiceImpl(userDao);
    }

    @Override
    protected String getManagementPage() {
        return "/admin/studentManagement.jsp";
    }



}
