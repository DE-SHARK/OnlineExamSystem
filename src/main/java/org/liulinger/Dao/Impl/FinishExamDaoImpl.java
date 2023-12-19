package org.liulinger.Dao.Impl;

import org.liulinger.Dao.FinishExamDao;
import org.liulinger.Utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FinishExamDaoImpl implements FinishExamDao {
    @Override
    public String FinishExam(int exam_id, String stu_id) {
        try (Connection connection = JDBCUtils.getConnection()) {
            String sql = "insert into studentExamStatus (stu_id, exam_id, status) values(?,?,1)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, stu_id);
                preparedStatement.setInt(2, exam_id);

                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    return "提交成功";
                } else {
                    return "未能成功提交";
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
