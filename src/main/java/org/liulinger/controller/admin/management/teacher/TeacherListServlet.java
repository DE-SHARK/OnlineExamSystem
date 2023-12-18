package org.liulinger.controller.admin.management.teacher;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.liulinger.Bean.UserBean;
import org.liulinger.Dao.Impl.UserDaoImpl;
import org.liulinger.Dao.UserDao;
import org.liulinger.Service.Impl.TeacherListServiceImpl;
import org.liulinger.Service.UserListService;

import java.io.IOException;
import java.util.List;

@WebServlet("/admin/teacher-list")
public class TeacherListServlet extends HttpServlet {

    private UserListService userListService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        // 进行依赖注入
        UserDao userDao = new UserDaoImpl();
        this.userListService = new TeacherListServiceImpl(userDao);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        handleRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        handleRequest(request, response);
    }

    private void handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 获取当前页面
        int currentPage = extractPage(request);
        String pageParam = request.getParameter("page");
        if (pageParam != null && !pageParam.isEmpty()) {
            try {
                currentPage = Integer.parseInt(pageParam);
            } catch (NumberFormatException e) {
                // 处理非法页码输入，默认为第一页
                // 即什么也不做
            }
        }

        // 每页显示的记录数
        int recordsPerPage = 5;

        // 计算偏移量
        int offset = (currentPage - 1) * recordsPerPage;

        // 获取用户列表和总记录数
        List<UserBean> userList = userListService.getUsers(offset, recordsPerPage);
        int totalUsers = userListService.getTotalUsers();
        int totalPages = (int) Math.ceil((double) totalUsers / recordsPerPage);

        // 将数据存储到 request 中，以便在页面中使用
        request.setAttribute("userList", userList);
        request.setAttribute("totalUsers", totalUsers);
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("totalPages", totalPages);

        // 转发到用户列表页面
        request.getRequestDispatcher("/admin/teacherManagement.jsp").forward(request, response);
    }

    private int extractPage(HttpServletRequest request) {
        int currentPage = 1;
        String pageParam = request.getParameter("page");
        if (pageParam != null && !pageParam.isEmpty()) {
            try {
                currentPage = Integer.parseInt(pageParam);
            } catch (NumberFormatException e) {
                // 处理非法页码输入，默认为第一页
                // 即什么也不做
            }
        }
        return currentPage;
    }
}
