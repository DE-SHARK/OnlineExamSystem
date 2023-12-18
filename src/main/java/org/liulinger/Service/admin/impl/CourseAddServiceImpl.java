package org.liulinger.Service.admin.impl;

import org.liulinger.Bean.CourseBean;
import org.liulinger.Dao.CourseDao;
import org.liulinger.Service.admin.CourseAddService;

public class CourseAddServiceImpl implements CourseAddService {

    private final CourseDao courseDao;

    public CourseAddServiceImpl(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    @Override
    public boolean courseAdd(CourseBean course) {

        // 执行添加操作
        return courseDao.addCourse(course);

    }

}
