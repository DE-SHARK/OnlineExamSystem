package org.liulinger.Bean;

import java.sql.Timestamp;

public class ExamBean {
    private String stuId;
    private int examId;
    private String examName;
    private Timestamp examDate;
    private Timestamp examEnd;
    private int timeLimits;
    private double score;
    private int status;
    private String testPaperUrl;

    private int courseId;

    public ExamBean() {
    }

    public ExamBean(String stuId, int examId, String examName, Timestamp examDate, Timestamp examEnd, int timeLimits, double score, int status, String testPaperUrl, int course_id) {
        this.stuId = stuId;
        this.examId = examId;
        this.examName = examName;
        this.examDate = examDate;
        this.examEnd = examEnd;
        this.timeLimits = timeLimits;
        this.score = score;
        this.status = status;
        this.testPaperUrl = testPaperUrl;
        this.courseId = course_id;
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

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public Timestamp getExamDate() {
        return examDate;
    }

    public void setExamDate(Timestamp examDate) {
        this.examDate = examDate;
    }

    public int getTimeLimits() {
        return timeLimits;
    }

    public void setTimeLimits(int timeLimits) {
        this.timeLimits = timeLimits;
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

    public Timestamp getExamEnd() {
        return examEnd;
    }

    public void setExamEnd(Timestamp examEnd) {
        this.examEnd = examEnd;
    }

    public String getTestPaperUrl() {
        return testPaperUrl;
    }

    public void setTestPaperUrl(String testPaperUrl) {
        this.testPaperUrl = testPaperUrl;
    }public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
}
