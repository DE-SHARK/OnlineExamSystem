package me.xizhehong.Dao;

import me.xizhehong.Bean.User;

import java.sql.SQLException;

public interface LoginDao {
    public User Login(String username, String password) throws SQLException;
}
