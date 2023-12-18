package org.liulinger.Dao;

import org.liulinger.Bean.ChooseExamBean;

import java.util.List;


public interface ChooseExamDao {
    List<ChooseExamBean> ChooseExam(String course_name, String teacher_id);
}
