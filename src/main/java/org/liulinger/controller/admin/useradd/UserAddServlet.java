package org.liulinger.controller.admin.useradd;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.liulinger.Bean.UserBean;
import org.liulinger.Service.UserAddService;

import java.io.IOException;

public class UserAddServlet extends HttpServlet {

    private UserAddService userAddService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    protected void setUserAddService(UserAddService userAddService) {
        this.userAddService = userAddService;
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
