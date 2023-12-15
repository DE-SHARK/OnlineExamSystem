package org.liulinger.Bean;

import java.sql.Timestamp;

public class ExamBean {
    private String stu_id;
    private int exam_id;
    private String exam_name;
    private Timestamp exam_date;
    private int time_limits;
    private double score;

    public ExamBean() {
    }

    public ExamBean(String stu_id, int exam_id, String exam_name, Timestamp exam_date, int time_limits, double score) {
        this.stu_id = stu_id;
        this.exam_id = exam_id;
        this.exam_name = exam_name;
        this.exam_date = exam_date;
        this.time_limits = time_limits;
        this.score = score;
    }

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
}
