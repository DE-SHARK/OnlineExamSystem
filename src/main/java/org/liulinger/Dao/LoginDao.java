package org.liulinger.Dao;


public interface LoginDao {

    String getPasswordByUid(String uid);

    int getPermission(String uid);
}
