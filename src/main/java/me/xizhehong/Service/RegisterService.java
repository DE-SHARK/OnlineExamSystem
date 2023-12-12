package me.xizhehong.Service;

public interface RegisterService {
    void Register(String username, String password, String if_login);
    String Username_repeat(String username);
    String Count_Legality(String username, String password, String password1);
}
