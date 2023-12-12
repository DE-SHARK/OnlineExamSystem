package me.xizhehong.Dao;

import me.xizhehong.Bean.User;
import me.xizhehong.utils.Dbutils;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoginDao_impl extends Dbutils implements LoginDao {

    public User Login(String username, String password) throws SQLException {
        User user = null;

        String sql = "select * from user where username = ?";
        List param = new ArrayList();
        param.add(username);
        resultSet = query(sql,param);

        try {
        while (resultSet.next()){
            String hashpassword = resultSet.getString("password");
            boolean isPasswordCorrect = BCrypt.checkpw(password,hashpassword);
            if (!isPasswordCorrect){
                return user;
            }
            else {
            user = new User();
            user.setUid(resultSet.getInt("uid"));
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
            user.setPassword(resultSet.getString("if_login"));
            user.setPassword(resultSet.getString("role"));}
        }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            closeAll();
        }
        return user;
    }
}
