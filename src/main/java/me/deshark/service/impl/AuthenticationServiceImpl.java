package me.deshark.service.impl;

import me.deshark.dao.UserDao;
import me.deshark.dao.impl.UserDaoImpl;
import me.deshark.service.AuthenticationService;
import org.mindrot.jbcrypt.BCrypt;

public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserDao userDao = new UserDaoImpl();

    @Override
    public boolean checkPassword(String uid, String password) {
        String hashedPassword = userDao.getPasswordByUid(uid);
        return BCrypt.checkpw(password, hashedPassword);
    }

    @Override
    public int getPermission(String uid) {
        return userDao.getPermission(uid);
    }
}
