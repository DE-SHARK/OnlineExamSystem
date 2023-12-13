package me.deshark.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import me.deshark.bean.UserBean;
import me.deshark.dao.UserDao;
import me.deshark.dao.impl.UserDaoImpl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.UUID;

@WebServlet("/deshark/UpdateUserServlet")
@MultipartConfig
public class UpdateUserServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        // 获取用户输入的信息
        String uid = req.getParameter("uid");
        String email = req.getParameter("email");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String permission = req.getParameter("permission");
        String sex = req.getParameter("sex");

        // 将用户信息填入 UserBean
        UserBean user = new UserBean();
        user.setUid(uid);
        user.setEmail(email);
        user.setUsername(username);
        user.setPassword(password);
        user.setPermission(permission);
        user.setSex(sex);

        Part filePart;
        try {
            filePart = req.getPart("avatar_url");
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
        // 获取文件名
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();

        if (fileName.isEmpty()) {
            // 直接进行更新用户方法
            UpdateUser(user);
        } else {
            UpdateAvatar(fileName, filePart, user);
            UpdateUser(user);
        }
    }


    private void UpdateUser(UserBean user) {
        UserDao userDao = new UserDaoImpl();
        userDao.updateUser(user);
    }

    private void UpdateAvatar(String fileName, Part filePart, UserBean user) throws IOException {
        // 处理头像
        String newFileName = UUID.randomUUID() + "_" + fileName;

        String uploadPath = getServletContext().getRealPath("") + File.separator + "images";
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        filePart.write(uploadPath + File.separator + newFileName);

        // 设置用户的新头像路径
        user.setAvatar_url("images/" + newFileName);
    }

}
