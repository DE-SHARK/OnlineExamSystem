package me.xizhehong.Service;

import me.xizhehong.Bean.User;
import me.xizhehong.Dao.LoginDao;
import me.xizhehong.Dao.LoginDao_impl;

import java.sql.SQLException;

public class LoginService_impl implements LoginService {
    LoginDao loginDao = new LoginDao_impl();

    public User login(String username, String password) {
        try {
            return loginDao.Login(username,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
