package org.liulinger.Service;

import org.liulinger.Bean.StudentInformationBean;
import java.util.List;
public interface StudentInformationService {
    List<StudentInformationBean> getAllInformationByUid(String uid);
}
