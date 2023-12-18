package org.liulinger.controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.liulinger.Bean.UserBean;
import org.liulinger.Dao.Impl.UserDaoImpl;
import org.liulinger.Dao.UserDao;
import org.liulinger.Service.Impl.TeacherAddServiceImpl;
import org.liulinger.Service.UserAddService;

import java.io.IOException;

@WebServlet("/admin/teacher-add")
public class TeacherAddServlet extends HttpServlet {

    private UserAddService userAddService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        // 在这里进行依赖注入
        UserDao userDao = new UserDaoImpl();
        this.userAddService = new TeacherAddServiceImpl(userDao);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        // 获取用户输入
        String uid = req.getParameter("uid");
        String name = req.getParameter("name");
        String sex  = req.getParameter("sex");

        UserBean user = new UserBean();
        user.setUid(uid);
        user.setUsername(name);
        user.setSex(sex);

        // 调用 Service 操作
        userAddService.userAdd(user);

    }
}
