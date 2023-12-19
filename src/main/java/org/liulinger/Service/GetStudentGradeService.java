package org.liulinger.Service;

import org.liulinger.Bean.GradeBean;

import java.util.List;

public interface GetStudentGradeService {
    List<GradeBean> GetSTudentGrade(String stu_id);
}
