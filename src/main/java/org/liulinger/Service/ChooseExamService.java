package org.liulinger.Service;

import org.liulinger.Bean.ChooseExamBean;

import java.util.List;

public interface ChooseExamService {
    List<ChooseExamBean> ChooseExam(String course_name, String teacher_id);
}
