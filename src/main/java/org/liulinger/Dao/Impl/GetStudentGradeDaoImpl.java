package org.liulinger.Dao.Impl;

import org.liulinger.Bean.GradeBean;
import org.liulinger.Dao.GetStudentGradeDao;
import org.liulinger.Utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GetStudentGradeDaoImpl implements GetStudentGradeDao {
    @Override
    public List<GradeBean> GetStudentGrade(String stu_id) {
        List<GradeBean> list = new ArrayList<>();
//需要course_name,stu_id,grade
        try (Connection connection = JDBCUtils.getConnection()) {
            String sql = "SELECT name as course_name,score from exams,grades,users " +
                          "where users.uid = grades.stu_id and grades.course_id = exams.course_id and stu_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, stu_id);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        String course_name = resultSet.getString("course_name");
                        double grade = resultSet.getDouble("score");
                        GradeBean gradeBean = new GradeBean(grade,course_name);
                        list.add(gradeBean);
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
