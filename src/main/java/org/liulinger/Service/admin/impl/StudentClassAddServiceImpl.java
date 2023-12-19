package org.liulinger.Service.admin.impl;

import org.liulinger.Bean.StudentClassBean;
import org.liulinger.Dao.admin.StudentClassDao;
import org.liulinger.Service.admin.ItemAddService;

public class StudentClassAddServiceImpl implements ItemAddService<StudentClassBean> {

    private final StudentClassDao studentClassDao;

    public StudentClassAddServiceImpl(StudentClassDao studentClassDao) {
        this.studentClassDao = studentClassDao;
    }

    @Override
    public boolean addItem(StudentClassBean studentClass) {
        // 执行添加操作
        return studentClassDao.addStudentClass(studentClass);
    }
}
