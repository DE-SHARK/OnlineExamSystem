package org.liulinger.Dao;

import org.liulinger.Bean.ExamBean;

import java.util.List;

public interface ExamListDao {
     int getNumberOfExam(String stu_id);

     double getGrade(String stu_id, String exam_id);

     List<ExamBean> getUsersPaginated(int pageNo, int pageSize, String stu_id);

     String getUsername(String stu_id);


}
