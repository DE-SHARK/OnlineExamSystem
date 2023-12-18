package org.liulinger.controller.admin.itemAdd;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.liulinger.Dao.Impl.UserDaoImpl;
import org.liulinger.Dao.UserDao;
import org.liulinger.Service.admin.impl.TeacherAddServiceImpl;

import java.io.IOException;

@WebServlet("/admin/teacher-add")
public class TeacherAddServlet extends UserAddServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        // 在这里进行依赖注入
        UserDao userDao = new UserDaoImpl();
        setUserAddService(new TeacherAddServiceImpl(userDao));
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        super.doPost(req, resp);
    }
}
