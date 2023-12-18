package org.liulinger.controller.admin.itemAdd;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.liulinger.Bean.ClassBean;
import org.liulinger.Dao.admin.ClassDao;
import org.liulinger.Dao.admin.impl.ClassDaoImpl;
import org.liulinger.Service.admin.ClassAddService;
import org.liulinger.Service.admin.impl.ClassAddServiceImpl;

import java.io.IOException;

@WebServlet("/admin/class-add")
public class ClassAddServlet extends HttpServlet {

    private ClassAddService classAddService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        ClassDao classDao = new ClassDaoImpl();
        this.classAddService = new ClassAddServiceImpl(classDao);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        // 获取用户输入
        ClassBean classBean = new ClassBean();
        classBean.setClassName(req.getParameter("name"));

        // 调用 Service 操作
        boolean success = classAddService.classAdd(classBean);

        // 设置成功或失败消息
        String message = success ? "课程添加成功" : "课程添加失败";

        resp.getWriter().write(message);

    }


}
