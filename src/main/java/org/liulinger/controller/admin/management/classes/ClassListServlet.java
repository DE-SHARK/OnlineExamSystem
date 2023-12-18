package org.liulinger.controller.admin.management.classes;

import jakarta.servlet.annotation.WebServlet;
import org.liulinger.Bean.ClassBean;
import org.liulinger.Dao.admin.ClassDao;
import org.liulinger.Dao.admin.impl.ClassDaoImpl;
import org.liulinger.Service.admin.ItemListService;
import org.liulinger.Service.admin.impl.ClassListServiceImpl;
import org.liulinger.controller.admin.management.ItemListServlet;

@WebServlet("/admin/class-list")
public class ClassListServlet extends ItemListServlet<ClassBean> {

    @Override
    protected ItemListService<ClassBean> createItemListService() {
        ClassDao classDao = new ClassDaoImpl();
        return new ClassListServiceImpl(classDao);
    }

    @Override
    protected String getManagementPage() {
        return "/admin/classManagement.jsp";
    }
}
