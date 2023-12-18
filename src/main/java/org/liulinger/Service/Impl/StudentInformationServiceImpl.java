package org.liulinger.Service.Impl;

import org.liulinger.Bean.StudentInformationBean;
import org.liulinger.Dao.StudentInformationDao;
import org.liulinger.Service.StudentInformationService;

import java.util.List;

public class StudentInformationServiceImpl implements StudentInformationService {
    private  final StudentInformationDao studentInformationDao;

    public StudentInformationServiceImpl(StudentInformationDao studentInformationDao) {
        this.studentInformationDao = studentInformationDao;
    }

    @Override
    public List<StudentInformationBean> getStudentInformationByUid(String uid) {
        return studentInformationDao.getStudentInformationByUid(uid);
    }

    @Override
    public void updatePassword(String uid, String password) {
        studentInformationDao.updatePassword(uid,password);
    }

    @Override
    public void updateAvatar_url(String uid, String avatar_url) {
        studentInformationDao.updateAvatar_url(uid, avatar_url);
    }
}