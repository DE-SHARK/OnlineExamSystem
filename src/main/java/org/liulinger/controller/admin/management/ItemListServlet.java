package org.liulinger.controller.admin.management;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.liulinger.Service.admin.ItemListService;

import java.io.IOException;
import java.util.List;

public abstract class ItemListServlet<T> extends HttpServlet {

    private ItemListService<T> itemListService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        // 进行依赖注入
        itemListService = createItemListService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        handleRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        handleRequest(req, resp);
    }

    private void handleRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // 获取当前页面
        int currentPage = extractPage(req);
        String pageParam = req.getParameter("page");
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

        // 获取列表和总记录数
        List<T> itemList = itemListService.getItems(offset, recordsPerPage);
        int totalItems = itemListService.getTotalItems();
        int totalPages = (int) Math.ceil((double) totalItems / recordsPerPage);

        // 将数据存储到 request 中，以便在页面中使用
        req.setAttribute("itemList", itemList);
        req.setAttribute("totalItems", totalItems);
        req.setAttribute("currentPage", currentPage);
        req.setAttribute("totalPages", totalPages);

        // 转发到用户列表页面
        req.getRequestDispatcher(getManagementPage()).forward(req, resp);
    }

    protected abstract ItemListService<T> createItemListService();

    protected abstract String getManagementPage();

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
