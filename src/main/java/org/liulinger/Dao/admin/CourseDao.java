package org.liulinger.Dao.admin;

import org.liulinger.Bean.CourseBean;

import java.util.List;

public interface CourseDao {

    List<CourseBean> getCourses(int offset, int limit);

    int getTotalCourses();

    boolean addCourse(CourseBean course);

}
