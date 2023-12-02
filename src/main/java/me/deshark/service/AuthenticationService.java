package me.deshark.service;

public interface AuthenticationService {

    boolean isValidUser(String email, String password);

    int getPermission(String email);

}
