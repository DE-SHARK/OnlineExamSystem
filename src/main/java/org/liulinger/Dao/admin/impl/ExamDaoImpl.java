package org.liulinger.Dao.admin.impl;

import org.liulinger.Bean.ExamBean;
import org.liulinger.Dao.admin.ExamDao;
import org.liulinger.Utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExamDaoImpl implements ExamDao {
    @Override
    public List<ExamBean> getExams(int offset, int limit) {
        List<ExamBean> examList = new ArrayList<>();

        try (Connection connection = JDBCUtils.getConnection()) {
            String sql = "SELECT * FROM exams LIMIT ?, ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, offset);
                preparedStatement.setInt(2, limit);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    // 处理结果集
                    while (resultSet.next()) {
                        examList.add(getExam(resultSet));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return examList;
    }

    @Override
    public int getTotalExams() {
        String sql = "SELECT COUNT(*) FROM exams";
        try (Connection connection = JDBCUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                // 获取并返回结果集的第一列的值，即总记录数
                return resultSet.getInt(1);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    @Override
    public boolean addExam(ExamBean exam) {
        return false;
    }

    private ExamBean getExam(ResultSet resultSet) throws SQLException {
        ExamBean exam = new ExamBean();

        exam.setExamId(resultSet.getInt("id"));
        exam.setExamName(resultSet.getString("name"));
        exam.setCourseId(resultSet.getInt("course_id"));

        // 判断是否为选修
        if (resultSet.getInt("class_id") == 0) {
            exam.setTrueClassId(resultSet.getInt("second_class_id"));
            exam.setMandatory(false);
        } else {
            exam.setTrueClassId(resultSet.getInt("class_id"));
            exam.setMandatory(true);
        }

        exam.setExamDate(resultSet.getTimestamp("exam_date"));
        exam.setTimeLimits(resultSet.getInt("time_limits"));
        exam.setTestPaperUrl(resultSet.getString("testpaper_url"));

        return exam;
    }
}
