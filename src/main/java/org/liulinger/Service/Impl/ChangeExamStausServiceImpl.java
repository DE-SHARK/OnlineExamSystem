package org.liulinger.Service.Impl;

import org.liulinger.Dao.ChangeExamStausDao;
import org.liulinger.Dao.Impl.ChangeExamStausDaoImpl;
import org.liulinger.Service.ChangeExamStausService;

public class ChangeExamStausServiceImpl implements ChangeExamStausService {
    ChangeExamStausDao changeExamStausDao = new ChangeExamStausDaoImpl();
    public ChangeExamStausServiceImpl() {

    }

    @Override
    public String ChangeExamStaus(String stu_id, int course_id, int exam_id, double score) {
        return changeExamStausDao.ChangeExamStaus(stu_id,course_id,exam_id,score);
    }
}
