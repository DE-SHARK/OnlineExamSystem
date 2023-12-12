package me.xizhehong.Dao;

import me.xizhehong.Bean.Student;
import me.xizhehong.utils.Dbutils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserMangeDao_impl extends Dbutils implements UserMangeDao {
    @Override
    public List UserMangeDao() {
        List list = new ArrayList();
        String sql = "select * from student ";
        resultSet = query(sql,null);

        try {
            while (resultSet.next()){
                Student student = new Student();
                student.setUid(resultSet.getInt("uid"));
                student.setUsername(resultSet.getString("username"));
                student.setRealname(resultSet.getString("realname"));
                student.setUsernumber(resultSet.getString("usernumber"));
                student.setSex(resultSet.getString("sex"));
                student.setProfession(resultSet.getString("profession"));
                list.add(student);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeAll();
        }
        return list;
    }
}
