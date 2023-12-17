package org.liulinger.Dao.Impl;


import org.liulinger.Bean.StudentInformationBean;
import org.liulinger.Dao.StudentInformationDao;
import org.liulinger.Utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentInformationDaoImpl implements StudentInformationDao {
    @Override
    public List<StudentInformationBean> getStudentInformationByUid(String uid) {
        List<StudentInformationBean> stuList = new ArrayList<>();
        String sql = "SELECT uid AS uid,email As email,username AS username," +
                "sex AS sex,avatar_url AS avatar_url FROM users WHERE uid = ?";
        PreparedStatement preparedStatement;
        try (Connection connection = JDBCUtils.getConnection()) {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, uid);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String resultUid = resultSet.getString("uid");
                    String resultEmail = resultSet.getString("email");
                    String resultUsername = resultSet.getString("username");
                    String resultSex = resultSet.getString("sex");
                    String resultAvatar_url = resultSet.getString("avatar_url");

                    StudentInformationBean stuInform = new StudentInformationBean(
                            resultUid,resultEmail,resultUsername,resultSex,resultAvatar_url
                    );
                    stuList.add(stuInform);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return stuList;
    }
}