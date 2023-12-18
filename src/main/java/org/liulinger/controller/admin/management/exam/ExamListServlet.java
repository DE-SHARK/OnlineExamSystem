package org.liulinger.controller.admin.management.exam;

import jakarta.servlet.annotation.WebServlet;
import org.liulinger.Bean.ExamBean;
import org.liulinger.Dao.admin.ExamDao;
import org.liulinger.Dao.admin.impl.ExamDaoImpl;
import org.liulinger.Service.admin.ItemListService;
import org.liulinger.Service.admin.impl.ExamListServiceImpl;
import org.liulinger.controller.admin.management.ItemListServlet;

@WebServlet("/admin/exam-list")
public class ExamListServlet extends ItemListServlet<ExamBean> {

    @Override
    protected ItemListService<ExamBean> createItemListService() {
        ExamDao examDao = new ExamDaoImpl();
        return new ExamListServiceImpl(examDao);
    }

    @Override
    protected String getManagementPage() {
        return "/admin/examManagement.jsp";
    }
}
