package org.liulinger.Service.admin.impl;

import org.liulinger.Bean.CourseBean;
import org.liulinger.Dao.admin.CourseDao;
import org.liulinger.Service.admin.ItemListService;

import java.util.List;

public class CourseListServiceImpl implements ItemListService<CourseBean> {

    private final CourseDao courseDao;

    public CourseListServiceImpl(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    @Override
    public List<CourseBean> getItems(int offset, int limit) {
        return courseDao.getCourses(offset, limit);
    }

    @Override
    public int getTotalItems() {
        return courseDao.getTotalCourses();
    }
}
