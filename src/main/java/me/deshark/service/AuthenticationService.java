package me.deshark.service;

public interface AuthenticationService {

    boolean checkPassword(String uid, String password);

    int getPermission(String email);

}
