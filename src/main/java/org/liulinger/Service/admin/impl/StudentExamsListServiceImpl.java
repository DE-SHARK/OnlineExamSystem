package org.liulinger.Service.admin.impl;

import org.liulinger.Bean.ExamBean;
import org.liulinger.Dao.admin.ClassDao;
import org.liulinger.Dao.admin.ExamDao;
import org.liulinger.Dao.admin.impl.ClassDaoImpl;
import org.liulinger.Service.admin.ItemListService;

import java.util.List;

public class StudentExamsListServiceImpl implements ItemListService<ExamBean> {

    private final ExamDao examDao;  // 通过成员变量保存依赖

    public StudentExamsListServiceImpl(ExamDao examDao) {
        this.examDao = examDao;  // 注入依赖
    }

    @Override
    public List<ExamBean> getItems(int offset, int limit) {
        // 获取学号
        String uid = "2100502101";

        ClassDao classDao = new ClassDaoImpl();

        return examDao.getExamsByUid(offset, limit, classDao.getClassIdByUid(uid));
    }

    @Override
    public int getTotalItems() {
        return examDao.getTotalExams();
    }
}
