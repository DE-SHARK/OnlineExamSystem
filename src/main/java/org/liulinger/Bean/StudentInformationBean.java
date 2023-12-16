package org.liulinger.Bean;

public class StudentInformationBean {

    private String avatar_url;
    private String uid;
    private String username;

    private String email;
    private String sex;

    public StudentInformationBean() {
    }

    public StudentInformationBean(String avatar_url, String uid, String email, String username, String sex) {
        this.avatar_url = avatar_url;
        this.uid = uid;
        this.username = username;
        this.email = email;
        this.sex = sex;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}