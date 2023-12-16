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



public class StudentInformationDaoImpl implements StudentInformationDao{
    @Override
    public List<StudentInformationBean> getAllInformationByUid(String uid) {
        List list = new ArrayList();
        try(Connection connection = JDBCUtils.getConnection()){
            String sql ="SELECT avatar_url AS avatar_url,uid AS uid,email AS email,username AS username,sex AS sex " +
                    "FROM users WHERE uid = ?";

            try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
                preparedStatement.setString(1,uid);     // 将stu_id的值设置为SQL语句中第一个问号（?）的值
                try(ResultSet resultSet = preparedStatement.executeQuery()){
                    while (resultSet.next()) {
                        String reslut_avatar_url = resultSet.getString("avatar_url");
                        String reslut_uid = resultSet.getString("uid");
                        String reslut_email = resultSet.getString("email");
                        String reslut_username = resultSet.getString("username");
                        String reslut_sex = resultSet.getString("sex");

                        StudentInformationBean studentInformationBean = new StudentInformationBean(reslut_avatar_url,reslut_uid, reslut_email, reslut_username, reslut_sex);
                        list.add(studentInformationBean);
                    }
                }

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;
    }
}
