package org.liulinger.Service;

import org.liulinger.Bean.StudentInformationBean;

import java.util.List;

public interface StudentInformationService {
    List<StudentInformationBean> getStudentInformationByUid(String uid);

    void updatePassword(String uid,String password);

    void updateAvatar_url(String uid, String avatar_url);
}