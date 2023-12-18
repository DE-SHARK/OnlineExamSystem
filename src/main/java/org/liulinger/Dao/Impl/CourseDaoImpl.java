package org.liulinger.Dao.Impl;

import org.liulinger.Bean.CourseBean;
import org.liulinger.Dao.CourseDao;
import org.liulinger.Utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDaoImpl implements CourseDao {
    @Override
    public List<CourseBean> getCourses(int offset, int limit) {

        List<CourseBean> courseList = new ArrayList<>();

        try (Connection connection = JDBCUtils.getConnection()) {
            String sql = "SELECT * FROM courses LIMIT ?, ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, offset);
                preparedStatement.setInt(2, limit);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    // 处理结果集
                    while (resultSet.next()) {
                        courseList.add(getCourse(resultSet));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return courseList;
    }

    @Override
    public int getTotalCourses() {

        String sql = "SELECT COUNT(*) FROM courses";

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
    public boolean addCourse(CourseBean course) {

        try (Connection connection = JDBCUtils.getConnection()) {
            String sql = "INSERT INTO courses (name, isMandatory) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, course.getCourseName());
                if (course.isMandatory()) {
                    preparedStatement.setInt(2, 1);
                } else {
                    preparedStatement.setInt(2, 2);
                }
                int rowsAffected = preparedStatement.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private CourseBean getCourse(ResultSet resultSet) throws SQLException {
        CourseBean course = new CourseBean();

        course.setCourseID(resultSet.getInt(1));
        course.setCourseName(resultSet.getString(2));
        if (resultSet.getInt(3) == 1) {
            course.setMandatory(true);
        } else if (resultSet.getInt(3) == 0) {
            course.setMandatory(false);
        }

        return course;
    }
}
