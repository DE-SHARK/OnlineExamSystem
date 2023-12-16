package org.liulinger.Service;

import org.liulinger.Bean.ExamBean;

import java.util.List;

public interface ExamListService {

    int getNumberOfExam(String stu_id);
    List<ExamBean> getUsersPaginated(int pageNo, int pageSize, String stu_id);

    String getUsername(String stu_id);
}
