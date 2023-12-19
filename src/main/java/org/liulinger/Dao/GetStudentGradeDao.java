package org.liulinger.Dao;

import org.liulinger.Bean.GradeBean;

import java.util.List;

public interface GetStudentGradeDao {
    List<GradeBean> GetStudentGrade(String stu_id);
}
