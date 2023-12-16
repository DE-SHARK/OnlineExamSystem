package org.liulinger.Service.Impl;

import org.liulinger.Bean.StudentInformationBean;
import org.liulinger.Dao.StudentInformationDao;
import org.liulinger.Service.StudentInformationService;

import java.util.List;
public class StudentInformationServiceImpl implements StudentInformationService{

    private final StudentInformationDao studentInformationDao;

    public StudentInformationServiceImpl(StudentInformationDao studentInformationDao) {
        this.studentInformationDao = studentInformationDao;
    }

    @Override
    public List<StudentInformationBean> getAllInformationByUid(String uid) {
        return studentInformationDao.getAllInformationByUid(uid);
    }
}

