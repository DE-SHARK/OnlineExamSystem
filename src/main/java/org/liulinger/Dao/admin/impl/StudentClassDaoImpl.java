package org.liulinger.Dao.admin.impl;

import org.liulinger.Bean.StudentClassBean;
import org.liulinger.Dao.admin.StudentClassDao;
import org.liulinger.Utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentClassDaoImpl implements StudentClassDao {

    @Override
    public boolean addStudentClass(StudentClassBean studentClass) {
        try (Connection connection = JDBCUtils.getConnection()) {
            String sql = "INSERT INTO studentClass (stu_id, class_id) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, studentClass.getUid());
                preparedStatement.setInt(2, studentClass.getClassId());
                int rowsAffected = preparedStatement.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
