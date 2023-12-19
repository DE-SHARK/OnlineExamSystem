package org.liulinger.Dao.admin;

import org.liulinger.Bean.ClassBean;

import java.util.List;

public interface ClassDao {

    List<ClassBean> getClasses(int offset, int limit);

    int getTotalClasses();

    boolean addClass(ClassBean classBean);

    int getClassIdByUid(String uid);
}
