package org.liulinger.Bean;

public class CourseBean {

    private int courseID;

    private String courseName;

    private boolean mandatory;

    public CourseBean() {
    }

    public String toString() {
        return "UserBean{" +
                "courseID='" + courseID + '\'' +
                ", courseName='" + courseName + '\'' +
                ", isMandatory='" + mandatory + '\'' +
                '}';
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public boolean isMandatory() {
        return mandatory;
    }

    public void setMandatory(boolean mandatory) {
        this.mandatory = mandatory;
    }
}
