package org.liulinger.Dao.admin;

import org.liulinger.Bean.ExamBean;

import java.util.List;

public interface ExamDao {

    List<ExamBean> getExams(int offset, int limit);

    int getTotalExams();

    boolean addExam(ExamBean exam);

}
