package org.liulinger.Bean;

public class GradeBean {
    private double grade;
    private String course_name;

    public GradeBean() {
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public GradeBean(double grade, String course_name) {
        this.grade = grade;
        this.course_name = course_name;
    }
}
