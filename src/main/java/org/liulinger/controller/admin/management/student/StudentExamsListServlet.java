package org.liulinger.controller.admin.management.student;

import jakarta.servlet.annotation.WebServlet;
import org.liulinger.Bean.ExamBean;
import org.liulinger.Dao.admin.ExamDao;
import org.liulinger.Dao.admin.impl.ExamDaoImpl;
import org.liulinger.Service.admin.ItemListService;
import org.liulinger.Service.admin.impl.StudentExamsListServiceImpl;
import org.liulinger.controller.admin.management.ItemListServlet;

@WebServlet("/admin/student-exam-list")
public class StudentExamsListServlet extends ItemListServlet<ExamBean> {

    @Override
    protected ItemListService<ExamBean> createItemListService() {
        ExamDao examDao = new ExamDaoImpl();
        return new StudentExamsListServiceImpl(examDao);
    }

    @Override
    protected String getManagementPage() {
        return "/admin/studentExamTest.jsp";
    }

}
