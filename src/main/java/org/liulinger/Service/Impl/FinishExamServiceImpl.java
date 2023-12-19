package org.liulinger.Service.Impl;

import org.liulinger.Dao.FinishExamDao;
import org.liulinger.Dao.Impl.FinishExamDaoImpl;
import org.liulinger.Service.FinishExamService;

public class FinishExamServiceImpl implements FinishExamService {

    FinishExamDao finishExamDao = new FinishExamDaoImpl();
    @Override
    public String FinishExam(int exam_id, String stu_id) {
        return finishExamDao.FinishExam(exam_id,stu_id);
    }
}
