package org.liulinger.Dao.Impl;

import org.liulinger.Bean.UserBean;
import org.liulinger.Dao.UserDao;
import org.liulinger.Utils.JDBCUtils;
import org.mindrot.jbcrypt.BCrypt;

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
        user.setPermission(resultSet.getInt("permission"));
        user.setSex(resultSet.getString("sex"));
        user.setAvatar_url(resultSet.getString("avatar_url"));
        user.setRegister_at(resultSet.getString("register_at"));
        return user;
    }

    @Override
    public boolean addUser(UserBean user) {

        String sql = "INSERT INTO users (uid, username, password, permission, sex) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = JDBCUtils.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getUid());
            preparedStatement.setString(2, user.getUsername());
            preparedStatement.setString(3, BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
            preparedStatement.setInt(4, user.getPermission());
            preparedStatement.setString(5, user.getSex());
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateUser(UserBean user) {

        String sql = "UPDATE users SET email = ?, username = ?, password = ?, permission = ?, sex = ?, avatar_url = ? WHERE uid = ?";
        try (Connection connection = JDBCUtils.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getUsername());
            // 哈希加盐处理密码
            preparedStatement.setString(3, BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
            preparedStatement.setInt(4, user.getPermission());
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
    public String getUsernameByUid(String uid) {
        String sql = "SELECT username FROM users WHERE uid = ?";
        try (Connection connection = JDBCUtils.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, uid);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getString("username");
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

        try (Connection connection = JDBCUtils.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
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
    public List<UserBean> getUsersByPermission(int permission, int offset, int limit) {

        List<UserBean> userList = new ArrayList<>();

        String sql = "SELECT * FROM users WHERE permission = ? LIMIT ?, ?";

        try (Connection connection = JDBCUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, permission);
            preparedStatement.setInt(2, offset);
            preparedStatement.setInt(3, limit);
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
    public int getTotalUsersByPermission(int permission) {
        String sql = "SELECT COUNT(*) FROM users WHERE permission = ?";

        try (Connection connection = JDBCUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, permission);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    // 获取并返回结果集的第一列的值，即总记录数
                    return resultSet.getInt(1);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return 0;
    }
}