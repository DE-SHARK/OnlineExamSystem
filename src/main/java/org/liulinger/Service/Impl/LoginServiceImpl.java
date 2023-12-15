package org.liulinger.Service.Impl;

import org.liulinger.Dao.LoginDao;
import org.liulinger.Service.LoginService;
import org.mindrot.jbcrypt.BCrypt;


public class LoginServiceImpl implements LoginService {

    private final LoginDao loginDao;  // 通过成员变量保存依赖

    // 构造函数接受LoginDao实例作为参数
    public LoginServiceImpl(LoginDao loginDao) {
        this.loginDao = loginDao;  // 注入依赖
    }

    @Override
    // 检查账号密码是否正确
    public boolean checkPassword(String uid, String password) {
        String hashedPassword = loginDao.getPasswordByUid(uid);
        return BCrypt.checkpw(password, hashedPassword);
    }

    @Override
    // 获取用户权限
    public int getPermission(String uid) {
        return loginDao.getPermission(uid);
    }

}
