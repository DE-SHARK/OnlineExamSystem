package me.deshark.dao.impl;

import me.deshark.bean.UserBean;
import me.deshark.dao.UserDao;
import me.deshark.jdbc.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private UserBean getUser(ResultSet resultSet) throws SQLException {
        // 从结果集中获取用户的所有信息
        UserBean user = new UserBean();
        user.setUid(resultSet.getString("uid"));
        user.setEmail(resultSet.getString("email"));
        user.setUsername(resultSet.getString("username"));
        user.setPassword(resultSet.getString("password"));
        user.setPermission(resultSet.getString("permission"));
        user.setSex(resultSet.getString("sex"));
        user.setAvatar_url(resultSet.getString("avatar_url"));
        user.setRegister_at(resultSet.getString("register_at"));
        return user;
    }

    @Override
    public boolean isValidUser(String uid, String password) {
        // 这是一个完美的将 SQL 语句的定义仍然在 try 块内且能够确保在使用完毕后 try-with-resources 中的资源会被正确地关闭的例子
        try (Connection connection = JDBCUtils.getConnection()) {
            String sql = "SELECT * FROM users WHERE uid = ? AND password = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, uid);
                preparedStatement.setString(2, password);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    // 如果查询结果存在，则表示用户名和密码匹配
                    return resultSet.next();
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

    @Override
    public void addUser(UserBean user) {

        if (user.getUid() == null || user.getUid().isEmpty()) {
            // 处理学号为空的情况
            String sql = "INSERT INTO users (email, username, password) VALUES (?, ?, ?)";
            try (Connection connection = JDBCUtils.getConnection()) {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, user.getEmail());
                preparedStatement.setString(2, user.getUsername());
                preparedStatement.setString(3, user.getPassword());
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else {
            // 处理学号不为空的情况
            String sql = "INSERT INTO users (uid, email, username, password, sex, register_at) VALUES (?, ?, ?, ?, ?, ?)";
            try (Connection connection = JDBCUtils.getConnection()) {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, user.getUid());
                preparedStatement.setString(2, user.getEmail());
                preparedStatement.setString(3, user.getUsername());
                preparedStatement.setString(4, user.getPassword());
                preparedStatement.setString(5, user.getSex());
                preparedStatement.setString(6, user.getRegister_at());
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void updateUser(UserBean user) {
        String sql = "UPDATE users SET email = ?, username = ?, password = ?, permission = ?, sex = ?, avatar_url = ? WHERE uid = ?";
        try (Connection connection = JDBCUtils.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getUsername());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getPermission());
            preparedStatement.setString(5, user.getSex());
            preparedStatement.setString(6, user.getAvatar_url());
            preparedStatement.setString(7, user.getUid());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteUser(String username) {
        String sql = "DELETE FROM users WHERE username =?";
        try (Connection connection = JDBCUtils.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public UserBean getUserByUsername(String username) {
        String sql = "SELECT * FROM users WHERE username = ?";
        PreparedStatement preparedStatement;
        try (Connection connection = JDBCUtils.getConnection()) {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {

                    return getUser(resultSet);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public int getPermissionByEmail(String email) {
        String sql = "SELECT permission FROM users WHERE email = ?";
        PreparedStatement preparedStatement = null;

        try (Connection connection = JDBCUtils.getConnection()) {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, email);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt("permission");
                } else {
                    throw new SQLException("无法通过邮箱查询到权限，可能是邮箱不存在：" + email);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<UserBean> getUsers(int offset, int limit) {

        List<UserBean> userList = new ArrayList<>();

        String sql = "SELECT * FROM users LIMIT ?, ?";

        try (Connection connection = JDBCUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, offset);
            preparedStatement.setInt(2, limit);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                // 处理结果集
                while (resultSet.next()) {
                    userList.add(getUser(resultSet));
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return userList;
    }

    @Override
    public List<UserBean> getAllUsers() {
        List<UserBean> userList = new ArrayList<>();

        String sql = "SELECT * FROM users";

        try (Connection connection = JDBCUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                // 处理结果集
                while (resultSet.next()) {
                    userList.add(getUser(resultSet));
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return userList;
    }

    @Override
    public int getTotalUsers() {
        String sql = "SELECT COUNT(*) FROM users";


        try (Connection connection = JDBCUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                // 获取并返回结果集的第一列的值，即总记录数
                return resultSet.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return 0;
    }
}
