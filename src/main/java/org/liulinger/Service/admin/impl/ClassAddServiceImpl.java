package org.liulinger.Service.admin.impl;

import org.liulinger.Bean.ClassBean;
import org.liulinger.Dao.admin.ClassDao;
import org.liulinger.Service.admin.ItemAddService;

public class ClassAddServiceImpl implements ItemAddService<ClassBean> {

    private final ClassDao classDao;

    public ClassAddServiceImpl(ClassDao classDao) {
        this.classDao = classDao;
    }

    @Override
    public boolean addItem(ClassBean classBean) {
        // 执行添加操作
        return classDao.addClass(classBean);
    }
}
