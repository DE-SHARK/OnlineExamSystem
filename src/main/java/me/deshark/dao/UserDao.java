package me.deshark.dao;

import me.deshark.bean.UserBean;

import java.util.List;

public interface UserDao {

    boolean isValidUser(String uid, String password);

    int getPermission(String uid);

    void addUser(UserBean user);
    void updateUser(UserBean user);
    void deleteUser(String user);
    UserBean getUserByUsername(String username);
    int getPermissionByEmail(String email);
    List<UserBean> getUsers(int offset, int limit);
    List<UserBean> getAllUsers();
    int getTotalUsers();

}
