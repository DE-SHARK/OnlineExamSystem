package org.liulinger.Dao.Impl;

import org.liulinger.Dao.ExamPageDao;
import org.liulinger.Utils.JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;

public class ExamPageDaoImpl implements ExamPageDao {
    @Override
    public int getExamStatus(String stu_id) {
        return 0;
    }

    @Override
    public Timestamp getExamDate(String stu_id) {
        try(Connection connection = JDBCUtils.getConnection()) {
            String sql = "";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;

    }
}
