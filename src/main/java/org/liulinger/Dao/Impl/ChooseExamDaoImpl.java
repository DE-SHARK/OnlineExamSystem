package org.liulinger.Dao.Impl;

import org.liulinger.Bean.ChooseExamBean;
import org.liulinger.Dao.ChooseExamDao;
import org.liulinger.Utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ChooseExamDaoImpl implements ChooseExamDao {
    @Override
    public List<ChooseExamBean> ChooseExam(String course_name, String teacher_id) {
        List<ChooseExamBean> list = new ArrayList<>();

        try (Connection connection = JDBCUtils.getConnection()) {
            String sql = "select username,testpaper_url,stu_id from teacherClass,classCourse,exams,grades,users " +
                    "where teacherClass.class_id = classCourse.class_id and" +
                    " classCourse.course_id = exams.course_id and " +
                    "exams.course_id = grades.course_id and  grades.stu_id = users.uid and " +
                    "teacherClass.teacher_id = ? and  exams.name = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    preparedStatement.setString(1, teacher_id);
                    preparedStatement.setString(2, course_name);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        String stu_name = resultSet.getString("username");
                        String stu_id = resultSet.getString("stu_id");
                        String testpaper_url = resultSet.getString("testpaper_url");
                        ChooseExamBean chooseExamBean = new ChooseExamBean(stu_id,stu_name,course_name,testpaper_url);
                        list.add(chooseExamBean);
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
