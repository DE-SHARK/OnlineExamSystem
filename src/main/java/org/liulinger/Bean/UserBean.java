package org.liulinger.Bean;

public class UserBean {

    // 转 String 方法
    public String toString() {
        return "UserBean{" +
                "uid='" + uid + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", permission='" + permission + '\'' +
                ", sex='" + sex + '\'' +
                ", avatar_url='" + avatar_url + '\'' +
                ", register_at='" + register_at + '\'' +
                '}';
    }

    // 类属性
    private String uid;
    private String username;
    private String password;
    private String email;
    private int permission;
    private String sex;
    private String avatar_url;
    private String register_at;

    // 空参构造
    public UserBean() {
    }

    // 有参构造（应该用不上）
    public UserBean(String uid) {
        this.uid = uid;
    }


    // set 和 get 方法
    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPermission() {
        return permission;
    }

    public void setPermission(int permission) {
        this.permission = permission;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getRegister_at() {
        return register_at;
    }

    public void setRegister_at(String register_at) {
        this.register_at = register_at;
    }
}