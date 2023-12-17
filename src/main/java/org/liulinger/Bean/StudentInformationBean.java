package org.liulinger.Bean;

public class StudentInformationBean {

    @Override
    public String toString() {
        return "StudentInformationBean{" +
                "uid='" + uid + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", sex='" + sex + '\'' +
                ", avatar_url='" + avatar_url + '\'' +
                '}';
    }

    private String uid;

    private String email;

    private String username;

    private String sex;

    private String avatar_url;

    public StudentInformationBean() {
    }

    public StudentInformationBean(String uid, String email, String username, String sex, String avatar_url) {
        this.uid = uid;
        this.email = email;
        this.username = username;
        this.sex = sex;
        this.avatar_url = avatar_url;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
}