package me.xizhehong.Service;

import me.xizhehong.Dao.UserMangeDao;
import me.xizhehong.Dao.UserMangeDao_impl;

import java.util.List;

public class UserMangeService_impl implements UserMangeService {
    UserMangeDao userMangeDao = new UserMangeDao_impl();
    @Override
    public List UserMange() {
        return userMangeDao.UserMangeDao();
    }
}
