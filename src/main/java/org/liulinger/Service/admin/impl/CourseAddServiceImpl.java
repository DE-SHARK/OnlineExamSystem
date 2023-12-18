package org.liulinger.Service.admin.impl;

import org.liulinger.Bean.CourseBean;
import org.liulinger.Dao.admin.CourseDao;
import org.liulinger.Service.admin.ItemAddService;

public class CourseAddServiceImpl implements ItemAddService<CourseBean> {

    private final CourseDao courseDao;

    public CourseAddServiceImpl(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    @Override
    public boolean addItem(CourseBean course) {
        // 执行添加操作
        return courseDao.addCourse(course);
    }
}
