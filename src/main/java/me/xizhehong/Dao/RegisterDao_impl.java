package me.xizhehong.Dao;

import me.xizhehong.utils.Dbutils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RegisterDao_impl extends Dbutils implements RegisterDao {
    public void Register(String username, String password, String if_login) {
        String sql = "insert into user (username,password,if_login) values(?,?,?)";
        List list = new ArrayList();
        list.add(username);
        list.add(password);
        list.add(if_login);
        update(sql,list);
    }

    public String username_repeat(String username) {
        String answer = "yes";
        String sql = "select * from user where username = ?";
        List param = new ArrayList();
        param.add(username);
        resultSet = query(sql,param);
    try {
        if (resultSet.next()) {
            answer = "no";
            return answer;
        }
    }catch (SQLException e) {
        throw new RuntimeException(e);
    }
    finally {
        closeAll();
    }
    return answer;
    }
}

