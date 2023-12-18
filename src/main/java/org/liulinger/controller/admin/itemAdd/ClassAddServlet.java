package org.liulinger.controller.admin.itemAdd;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.liulinger.Bean.ClassBean;
import org.liulinger.Dao.admin.ClassDao;
import org.liulinger.Dao.admin.impl.ClassDaoImpl;
import org.liulinger.Service.admin.ItemAddService;
import org.liulinger.Service.admin.impl.ClassAddServiceImpl;

import java.io.IOException;

@WebServlet("/admin/class-add")
public class ClassAddServlet extends UserAddServlet<ClassBean> {

    @Override
    protected ItemAddService<ClassBean> createItemAddService() {
        ClassDao classDao = new ClassDaoImpl();
        return new ClassAddServiceImpl(classDao);
    }

    @Override
    void handleRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 获取用户输入
        ClassBean classBean = new ClassBean();
        classBean.setClassName(req.getParameter("name"));

        // 调用 Service 操作
        boolean success = getItemAddService().addItem(classBean);

        // 设置成功或失败消息
        String message = success ? "课程添加成功" : "课程添加失败";

        resp.getWriter().write(message);
    }


}
