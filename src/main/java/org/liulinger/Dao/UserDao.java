package org.liulinger.Dao;

import org.liulinger.Bean.UserBean;

import java.util.List;

public interface UserDao {

    void addUser(UserBean user);

    void updateUser(UserBean user);

    void deleteUser(String user);

    UserBean getUserByUsername(String username);

    int getPermissionByEmail(String email);

    List<UserBean> getUsersByPermission(int permission, int offset, int limit);

    List<UserBean> getAllUsers();

    int getTotalUsersByPermission(int permission);

}
