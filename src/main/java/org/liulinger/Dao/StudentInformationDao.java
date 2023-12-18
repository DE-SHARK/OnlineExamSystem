package org.liulinger.Dao;


import org.liulinger.Bean.StudentInformationBean;

import java.util.List;

public interface StudentInformationDao {
    List<StudentInformationBean> getStudentInformationByUid(String uid);

    void updatePassword(String uid,String password);

    void updateAvatar_url(String uid ,String avatar_url);
}