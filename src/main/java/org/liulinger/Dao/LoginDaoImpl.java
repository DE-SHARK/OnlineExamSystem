package org.liulinger.Dao;

import org.liulinger.Utils.JDBCUtils ;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDaoImpl implements LoginDao {

    @Override
    public String getPasswordByUid(String uid) {

        // 这是一个标准的执行 SQL 语句的示例
        // 在 try-with-resources 中创建资源，并确保在使用完毕后会被正确地关闭
        try (Connection connection = JDBCUtils.getConnection()) {
            String sql = "SELECT password FROM users WHERE uid = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, uid);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    // 如果查询结果存在，则表示用户名和密码匹配
                    if (resultSet.next()) {
                        return resultSet.getString(1);
                    } else {
                        return "null";
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int getPermission(String uid) {
        try (Connection connection = JDBCUtils.getConnection()) {
            String sql = "SELECT permission FROM users WHERE uid = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, uid);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()){
                        return resultSet.getInt(1);
                    } else {
                        return 0;
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
