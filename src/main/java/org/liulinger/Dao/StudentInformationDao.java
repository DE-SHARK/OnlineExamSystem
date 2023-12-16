package org.liulinger.Dao;

import org.liulinger.Bean.StudentInformationBean;
import java.util.List;
public interface StudentInformationDao {

    List<StudentInformationBean> getAllInformationByUid(String uid);
}
