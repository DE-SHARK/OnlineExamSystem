package org.liulinger.Service.admin.impl;

import org.liulinger.Bean.ExamBean;
import org.liulinger.Dao.admin.ExamDao;
import org.liulinger.Service.admin.ItemListService;

import java.util.List;

public class ExamListServiceImpl implements ItemListService<ExamBean> {

    private final ExamDao examDao;

    public ExamListServiceImpl(ExamDao examDao) {
        this.examDao = examDao;
    }

    @Override
    public List<ExamBean> getItems(int offset, int limit) {
        return examDao.getExams(offset, limit);
    }

    @Override
    public int getTotalItems() {
        return examDao.getTotalExams();
    }
}
