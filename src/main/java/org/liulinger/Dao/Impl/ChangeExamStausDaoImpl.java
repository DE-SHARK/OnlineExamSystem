package org.liulinger.Dao.Impl;

import org.liulinger.Dao.ChangeExamStausDao;
import org.liulinger.Utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ChangeExamStausDaoImpl implements ChangeExamStausDao {
    @Override
    public String ChangeExamStaus(String stu_id, int course_id, int exam_id, double score) {
        try (Connection connection = JDBCUtils.getConnection()) {
            String sql = "insert into grades (stu_id, course_id, exam_id, score) values(?,?,?,?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, stu_id);
                preparedStatement.setInt(2, course_id);
                preparedStatement.setInt(3, exam_id);
                preparedStatement.setDouble(4, score);

                int rowsAffected = preparedStatement.executeUpdate();
                    if (rowsAffected > 0) {
                        return "更新成功";
                    } else {
                        return "未能更新记录";
                    }
                } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ChangeExamStausDaoImpl() {
    }
}
