package org.liulinger.controller.admin.itemAdd;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.liulinger.Bean.UserBean;
import org.liulinger.Dao.Impl.UserDaoImpl;
import org.liulinger.Dao.UserDao;
import org.liulinger.Service.admin.ItemAddService;
import org.liulinger.Service.admin.impl.TeacherAddServiceImpl;

import java.io.IOException;

@WebServlet("/admin/teacher-add")
public class TeacherAddServlet extends UserAddServlet<UserBean> {

    @Override
    protected ItemAddService<UserBean> createItemAddService() {
        UserDao userDao = new UserDaoImpl();
        return new TeacherAddServiceImpl(userDao);
    }

    @Override
    void handleRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 获取用户输入
        String uid = req.getParameter("uid");
        String name = req.getParameter("name");
        String sex  = req.getParameter("sex");

        UserBean user = new UserBean();
        user.setUid(uid);
        user.setUsername(name);
        user.setSex(sex);

        // 调用 Service 操作
        boolean success = getItemAddService().addItem(user);

        // 设置成功或失败消息
        String message = success ? "教师添加成功" : "教师添加失败";

        resp.getWriter().write(message);
    }
}
