package org.liulinger.Service;

import org.liulinger.Bean.ExamBean;
import org.liulinger.Dao.ExamListDao;

import java.util.List;

public class ExamListServiceImpl implements ExamListService{
    private final ExamListDao examListDao;

    public ExamListServiceImpl(ExamListDao examListDao) {
        this.examListDao = examListDao;
    }

    @Override
    public int getNumberOfExam(String stu_id) {
        return examListDao.getNumberOfExam(stu_id);
    }

    @Override
    public List<ExamBean> getUsersPaginated(int pageNo, int pageSize, String stu_id) {
        return examListDao.getUsersPaginated(pageNo, pageSize, stu_id);
    }
}
