package org.liulinger.Bean;

public class ChooseExamBean {
    private String stu_id;
    private String stu_name;
    private String course_name;
    private String testpaper_url;
    private int course_id;
    private int exam_id;

    public String getStu_id() {
        return stu_id;
    }

    public void setStu_id(String stu_id) {
        this.stu_id = stu_id;
    }

    public String getStu_name() {
        return stu_name;
    }

    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getTestpaper_url() {
        return testpaper_url;
    }

    public void setTestpaper_url(String testpaper_url) {
        this.testpaper_url = testpaper_url;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public int getExam_id() {
        return exam_id;
    }

    public void setExam_id(int exam_id) {
        this.exam_id = exam_id;
    }

    public ChooseExamBean() {
    }

    public ChooseExamBean(String stu_id, String stu_name, String course_name, String testpaper_url, int course_id, int exam_id) {
        this.stu_id = stu_id;
        this.stu_name = stu_name;
        this.course_name = course_name;
        this.testpaper_url = testpaper_url;
        this.course_id = course_id;
        this.exam_id = exam_id;
    }
}

