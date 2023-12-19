package org.liulinger.Service.Impl;

import org.liulinger.Bean.GradeBean;
import org.liulinger.Dao.GetStudentGradeDao;
import org.liulinger.Dao.Impl.GetStudentGradeDaoImpl;
import org.liulinger.Service.GetStudentGradeService;

import java.util.List;

public class GetStudentGradeServiceImpl implements GetStudentGradeService {

    GetStudentGradeDao getStudentGradeDao = new GetStudentGradeDaoImpl();
    @Override
    public List<GradeBean> GetSTudentGrade(String stu_id) {
        return getStudentGradeDao.GetStudentGrade(stu_id);
    }
}
