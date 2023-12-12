package me.xizhehong.Bean;

public class Student {
    private int uid;
    private String username;
    private String realname;
    private String usernumber;
    private String sex;
    private String profession;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getUsernumber() {
        return usernumber;
    }

    public void setUsernumber(String usernumber) {
        this.usernumber = usernumber;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public Student() {

    }

    public Student(int uid, String username, String realname, String usernumber, String sex, String profession) {
        this.uid = uid;
        this.username = username;
        this.realname = realname;
        this.usernumber = usernumber;
        this.sex = sex;
        this.profession = profession;
    }
}
