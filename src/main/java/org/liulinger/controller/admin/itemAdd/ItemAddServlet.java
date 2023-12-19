package org.liulinger.controller.admin.itemAdd;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.liulinger.Service.admin.ItemAddService;

import java.io.IOException;

public abstract class ItemAddServlet<T> extends HttpServlet {

    private ItemAddService<T> itemAddService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        // 进行依赖注入
        itemAddService = createItemAddService();
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        handleRequest(req, resp);
    }

    protected abstract ItemAddService<T> createItemAddService();

    abstract void handleRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException;

    public ItemAddService<T> getItemAddService() {
        return itemAddService;
    }
}
