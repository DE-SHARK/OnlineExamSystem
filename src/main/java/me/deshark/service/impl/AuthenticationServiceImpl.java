package me.deshark.service.impl;

import me.deshark.dao.UserDao;
import me.deshark.dao.impl.UserDaoImpl;
import me.deshark.service.AuthenticationService;

public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserDao userDao = new UserDaoImpl();

    @Override
    public boolean isValidUser(String uid, String password) {
        return userDao.isValidUser(uid, password);
    }

    @Override
    public int getPermission(String uid) {
        return userDao.getPermission(uid);
    }
}
