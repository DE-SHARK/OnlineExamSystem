package org.liulinger.Service;

public interface LoginService {

    boolean checkPassword(String uid, String password);

    int getPermission(String email);

    String getUsername(String uid);

}
