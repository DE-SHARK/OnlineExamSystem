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
//需要username,stu_id,testpaper_url,exam_name,teacher_id
        try (Connection connection = JDBCUtils.getConnection()) {
            String sql = "SELECT username,testpaper_url,stu_id,course_id,exams.id as exam_id " +
                    "FROM  users, teacherClass, classes, exams, studentClass " +
                    "WHERE teacherClass.class_id = classes.id AND users.uid = studentClass.stu_id " +
                    "  AND  studentClass.class_id = classes.id AND classes.id = exams.class_id " +
                    "  AND teacherClass.teacher_id = ? AND  exams.name = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    preparedStatement.setString(1, teacher_id);
                    preparedStatement.setString(2, course_name);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        String stu_name = resultSet.getString("username");
                        String stu_id = resultSet.getString("stu_id");
                        String testpaper_url = resultSet.getString("testpaper_url");
                        int course_id = resultSet.getInt("course_id");
                        int exam_id = resultSet.getInt("exam_id");
                        ChooseExamBean chooseExamBean = new ChooseExamBean(stu_id,stu_name,course_name,testpaper_url,course_id,exam_id);
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
