package me.xizhehong.Dao;

public interface RegisterDao {
    public void Register(String username, String password, String if_login);
    public String username_repeat(String username);
}
