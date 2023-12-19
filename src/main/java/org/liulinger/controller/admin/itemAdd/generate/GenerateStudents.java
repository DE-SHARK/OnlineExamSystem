package org.liulinger.controller.admin.itemAdd.generate;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletContext;
import org.liulinger.Dao.Impl.UserDaoImpl;
import org.liulinger.Dao.UserDao;
import org.liulinger.Service.admin.GenerateService;
import org.liulinger.Service.admin.impl.GenerateServiceImpl;

import java.io.IOException;

@WebServlet("/admin/generate-students")
public class GenerateStudents extends HttpServlet {

    private GenerateService generateService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        // 获取ServletContext对象
        ServletContext context = config.getServletContext();

        // 在这里进行依赖注入
        UserDao userDao = new UserDaoImpl();
        this.generateService = new GenerateServiceImpl(userDao, context);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 获取输入的基本信息
        String uidStart = req.getParameter("uidStart");
        try {
            int numbers = Integer.parseInt(req.getParameter("numberOfStudents"));

            // 执行随机添加学生方法
            generateService.doGenerate(uidStart, numbers ,1);

            // 获取成功消息
            String successMessage = generateService.getSuccessMessage();

            // 将成功消息放入请求属性中
            req.setAttribute("successMessage", successMessage);

            // 转发到一个包含成功消息的页面
            RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/student-management");
            dispatcher.forward(req, resp);

        } catch (NumberFormatException e) {

            // 将错误消息放入请求属性中
            req.setAttribute("errorMessage", "输入的学生数不是有效的整数。请提供有效的整数值。");

            // 转发到一个包含错误消息的页面
            RequestDispatcher dispatcher = req.getRequestDispatcher("/errorPage.jsp");
            dispatcher.forward(req, resp);

            throw new RuntimeException(e);
        }


    }
}
