package org.liulinger.Service.Impl;

import org.liulinger.Bean.ChooseExamBean;
import org.liulinger.Dao.ChooseExamDao;
import org.liulinger.Service.ChooseExamService;

import java.util.List;

public class ChooseExamServiceImpl implements ChooseExamService {
    private final ChooseExamDao chooseExamDao;
    public ChooseExamServiceImpl(ChooseExamDao chooseExamDao) {
        this.chooseExamDao = chooseExamDao;
    }

    @Override
    public List<ChooseExamBean> ChooseExam(String course_name, String teacher_id) {
        return chooseExamDao.ChooseExam(course_name,teacher_id);
    }
}
