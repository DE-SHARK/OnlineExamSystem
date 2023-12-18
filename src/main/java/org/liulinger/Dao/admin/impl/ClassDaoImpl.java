package org.liulinger.Dao.admin.impl;

import org.liulinger.Bean.ClassBean;
import org.liulinger.Dao.admin.ClassDao;
import org.liulinger.Utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassDaoImpl implements ClassDao {

    @Override
    public List<ClassBean> getClasses(int offset, int limit) {
        List<ClassBean> classList = new ArrayList<>();

        try (Connection connection = JDBCUtils.getConnection()) {
            String sql = "SELECT * FROM classes LIMIT ?, ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, offset);
                preparedStatement.setInt(2, limit);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    // 处理结果集
                    while (resultSet.next()) {
                        classList.add(getClass(resultSet));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return classList;
    }

    @Override
    public int getTotalClasses() {
        String sql = "SELECT COUNT(*) FROM classes";
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
    public boolean addClass(ClassBean classBean) {

        try (Connection connection = JDBCUtils.getConnection()) {
            String sql = "INSERT INTO classes (name) VALUES (?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, classBean.getClassName());
                int rowsAffected = preparedStatement.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private ClassBean getClass(ResultSet resultSet) throws SQLException {
        ClassBean classBean = new ClassBean();

        classBean.setClassID(resultSet.getInt(1));
        classBean.setClassName(resultSet.getString(2));

        return classBean;
    }
}
