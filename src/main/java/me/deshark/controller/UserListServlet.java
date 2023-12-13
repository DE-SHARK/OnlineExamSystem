package me.deshark.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import me.deshark.bean.UserBean;
import me.deshark.dao.UserDao;
import me.deshark.dao.impl.UserDaoImpl;

import java.io.IOException;
import java.util.List;

@WebServlet("/deshark/UserListServlet")
public class UserListServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 获取当前页码，默认为第一页
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

        // 每页显示的记录数
        int recordsPerPage = 5;

        // 计算偏移量
        int offset = (currentPage - 1) * recordsPerPage;

        // 获取用户列表和总记录数
        UserDao userDao = new UserDaoImpl();
        List<UserBean> userList = userDao.getUsers(offset, recordsPerPage);
        int totalUsers = userDao.getTotalUsers();

        // 计算总页数
        int totalPages = (int) Math.ceil((double) totalUsers / recordsPerPage);

        // 将数据存储到 request 中，以便在页面中使用
        request.setAttribute("userList", userList);
        request.setAttribute("totalUsers", totalUsers);
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("totalPages", totalPages);

        // 转发到用户列表页面
        request.getRequestDispatcher("/userList.jsp").forward(request, response);
    }

}
