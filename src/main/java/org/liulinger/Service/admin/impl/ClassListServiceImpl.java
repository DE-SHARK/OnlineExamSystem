package org.liulinger.Service.admin.impl;

import org.liulinger.Bean.ClassBean;
import org.liulinger.Dao.admin.ClassDao;
import org.liulinger.Service.admin.ItemListService;

import java.util.List;

public class ClassListServiceImpl implements ItemListService<ClassBean> {

    private final ClassDao classDao;

    public ClassListServiceImpl(ClassDao classDao) {
        this.classDao = classDao;
    }

    @Override
    public List<ClassBean> getItems(int offset, int limit) {
        return classDao.getClasses(offset, limit);
    }

    @Override
    public int getTotalItems() {
        return classDao.getTotalClasses();
    }
}
