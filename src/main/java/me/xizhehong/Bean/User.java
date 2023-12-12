package me.xizhehong.Bean;

public class User {
    private Integer uid;
    private String username;
    private String password;
    private String if_login;
    private String role;

    public User() {
    }

    public User(Integer uid, String username, String password, String if_login, String role) {
        this.uid = uid;
        this.username = username;
        this.password = password;
        this.if_login = if_login;
        this.role = role;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIf_login() {
        return if_login;
    }

    public void setIf_login(String if_login) {
        this.if_login = if_login;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
