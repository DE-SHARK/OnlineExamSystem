package org.liulinger.Service.admin.impl;

import org.liulinger.Bean.UserBean;
import org.liulinger.Dao.UserDao;
import org.liulinger.Service.admin.ItemAddService;

public class StudentAddServiceImpl implements ItemAddService<UserBean> {

    private final UserDao userDao;

    public StudentAddServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public boolean addItem(UserBean user) {

        // 获取学号最后六位数字并写入作密码
        user.setPassword(getLastSixDigits(user.getUid()));
        // 设置权限
        user.setPermission(1);

        // 执行添加操作
        return userDao.addUser(user);

    }

    // 获取最后六位数字的方法
    private static String getLastSixDigits(String originalString) {
        if (originalString.length() >= 6) {
            return originalString.substring(originalString.length() - 6);
        } else {
            // 如果字符串长度不足六位，你可以根据需求决定如何处理
            return originalString;
        }
    }
}
