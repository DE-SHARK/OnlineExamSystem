package org.liulinger.Dao;

import java.sql.Timestamp;

public interface ExamPageDao {
    int getExamStatus(String stu_id);

    Timestamp getExamDate(String stu_id);
}
