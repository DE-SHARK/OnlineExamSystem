package me.deshark.controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import me.deshark.jdbc.JDBCUtils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/CheckUsernameServlet")
public class CheckUsernameServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        // 获取前端传递的用户名参数
        String username = req.getParameter("username");

        // 检查用户名是否重复
        if (isUsernameAvailable(username)) {
            resp.getWriter().write("false");
        } else {
            resp.getWriter().write("true");
        }
    }

    public static boolean isUsernameAvailable(String username) {

        // 通过查询数据库来检查是否有同名用户
        String sql = "SELECT * FROM users WHERE username = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try  {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();

            return resultSet.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.closeConnection(connection);
        }
    }
}
