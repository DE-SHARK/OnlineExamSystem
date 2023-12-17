package org.liulinger.Bean;

import java.sql.Timestamp;

public class ExamBean {
    private String stu_id;
    private int exam_id;
    private String exam_name;
    private Timestamp exam_date;
    private Timestamp exam_end;
    private int time_limits;
    private double score;
    private int status;
    private String testpaper_url;

    public ExamBean() {
    }

    public ExamBean(String stu_id, int exam_id, String exam_name, Timestamp exam_date, Timestamp exam_end, int time_limits, double score, int status, String testpaper_url) {
        this.stu_id = stu_id;
        this.exam_id = exam_id;
        this.exam_name = exam_name;
        this.exam_date = exam_date;
        this.exam_end = exam_end;
        this.time_limits = time_limits;
        this.score = score;
        this.status = status;
        this.testpaper_url = testpaper_url;
    }
//    public ExamBean(String stu_id, int exam_id, String exam_name, Timestamp exam_date, Timestamp exam_end, int time_limits, double score, int status) {
//        this.stu_id = stu_id;
//        this.exam_id = exam_id;
//        this.exam_name = exam_name;
//        this.exam_date = exam_date;
//        this.exam_end = exam_end;
//        this.time_limits = time_limits;
//        this.score = score;
//        this.status = status;
//    }

    public String getStu_id() {
        return stu_id;
    }

    public void setStu_id(String stu_id) {
        this.stu_id = stu_id;
    }

    public int getExam_id() {
        return exam_id;
    }

    public void setExam_id(int exam_id) {
        this.exam_id = exam_id;
    }

    public String getExam_name() {
        return exam_name;
    }

    public void setExam_name(String exam_name) {
        this.exam_name = exam_name;
    }

    public Timestamp getExam_date() {
        return exam_date;
    }

    public void setExam_date(Timestamp exam_date) {
        this.exam_date = exam_date;
    }

    public int getTime_limits() {
        return time_limits;
    }

    public void setTime_limits(int time_limits) {
        this.time_limits = time_limits;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Timestamp getExam_end() {
        return exam_end;
    }

    public void setExam_end(Timestamp exam_end) {
        this.exam_end = exam_end;
    }

    public String getTestpaper_url() {
        return testpaper_url;
    }

    public void setTestpaper_url(String testpaper_url) {
        this.testpaper_url = testpaper_url;
    }
}
