package org.liulinger.Service.Impl;

import org.liulinger.Bean.UserBean;
import org.liulinger.Dao.UserDao;
import org.liulinger.Service.UserListService;

import java.util.List;

public class StudentListServiceImpl implements UserListService {

    private final UserDao userDao;  // 通过成员变量保存依赖

    public StudentListServiceImpl(UserDao userDao) {
        this.userDao = userDao;  // 注入依赖
    }

    @Override
    public List<UserBean> getUsers(int offset, int limit) {
        return userDao.getUsersByPermission(1, offset, limit);
    }

    @Override
    public int getTotalUsers() {
        return 0;
    }
}
