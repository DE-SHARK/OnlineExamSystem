package org.liulinger.controller.admin.itemAdd;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.liulinger.Bean.StudentClassBean;
import org.liulinger.Dao.admin.StudentClassDao;
import org.liulinger.Dao.admin.impl.StudentClassDaoImpl;
import org.liulinger.Service.admin.ItemAddService;
import org.liulinger.Service.admin.impl.StudentClassAddServiceImpl;

import java.io.IOException;

@WebServlet("/admin/student-class-add")
public class StudentClassAddServlet extends ItemAddServlet<StudentClassBean> {

    @Override
    protected ItemAddService<StudentClassBean> createItemAddService() {
        StudentClassDao studentClassDao = new StudentClassDaoImpl();
        return new StudentClassAddServiceImpl(studentClassDao);
    }

    @Override
    void handleRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 获取用户输入
        String uid = req.getParameter("uidStart");
        int numbers = Integer.parseInt(req.getParameter("numberOfStudents"));
        int classId = Integer.parseInt(req.getParameter("classId"));
        // 记录成功和失败数量
        int numberOfSuccesses = 0;
        int numberOfFailures = 0;

        for (int i = 0; i < numbers; i++) {
            StudentClassBean studentClass = new StudentClassBean();
            studentClass.setUid(uid);
            studentClass.setClassId(classId);
            // 调用 Service 操作
            boolean success = getItemAddService().addItem(studentClass);
            if (success) {
                numberOfSuccesses++;
            } else {
                numberOfFailures++;
            }
            uid = String.valueOf(Integer.parseInt(uid) + 1);
        }
        // 设置成功或失败消息
        String message = "添加" + numbers + "个学生，成功" + numberOfSuccesses + "个，失败" + numberOfFailures + "个";

        resp.getWriter().write(message);
    }
}
