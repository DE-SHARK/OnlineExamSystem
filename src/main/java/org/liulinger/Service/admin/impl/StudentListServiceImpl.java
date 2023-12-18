package org.liulinger.Service.admin.impl;

import org.liulinger.Bean.UserBean;
import org.liulinger.Dao.UserDao;
import org.liulinger.Service.admin.UserListService;

import java.util.List;

public class StudentListServiceImpl implements UserListService {

    private final int permission = 1;

    private final UserDao userDao;  // 通过成员变量保存依赖

    public StudentListServiceImpl(UserDao userDao) {
        this.userDao = userDao;  // 注入依赖
    }

    @Override
    public List<UserBean> getUsers(int offset, int limit) {
        return userDao.getUsersByPermission(permission, offset, limit);
    }

    @Override
    public int getTotalUsers() {
        return userDao.getTotalUsersByPermission(permission);
    }
}
