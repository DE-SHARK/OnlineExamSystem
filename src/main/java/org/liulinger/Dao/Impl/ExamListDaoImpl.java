package org.liulinger.Dao.Impl;

import org.liulinger.Bean.ExamBean;
import org.liulinger.Dao.ExamListDao;
import org.liulinger.Utils.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExamListDaoImpl implements ExamListDao {

    //获取分页
    @Override
    public List<ExamBean> getUsersPaginated(int pageNo, int pageSize, String stu_id) {
        List<ExamBean> examList = new ArrayList<>();
        if (pageNo < 1) {
            pageNo = 1;
        }
        int start = (pageNo - 1) * pageSize;
        try (Connection connection = JDBCUtils.getConnection()) {
            String sql = "SELECT exams.id AS exam_id, exams.name AS exam_name, exam_date, time_limits, score, status " +
                    "FROM users " +
                    "LEFT JOIN studentClass ON studentClass.stu_id = users.uid " +
                    "LEFT JOIN exams ON studentClass.class_id = exams.class_id " +
                    "LEFT JOIN grades ON exams.id = grades.exam_id AND users.uid = grades.stu_id " +
                    "LEFT JOIN courses ON exams.course_id = courses.id " +
                    "LEFT JOIN studentExamStatus ON exams.id = studentExamStatus.exam_id AND studentExamStatus.stu_id = users.uid " +
                    "WHERE users.uid = ? " +
                    "LIMIT ?, ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, stu_id);
                preparedStatement.setInt(2, start);
                preparedStatement.setInt(3, pageSize);
                System.out.println("looking for");
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()){
//                        ExamBean exam = new ExamBean();
//                        exam.setExam_id(resultSet.getInt("exam_id"));
//                        exam.setExam_name(resultSet.getString("exam_name"));
//                        exam.setExam_date(resultSet.getTimestamp("exam_date"));
//                        exam.setTime_limits(resultSet.getInt("time_limits"));
//                        exam.setScore(resultSet.getDouble("score"));
//                        exam.setStatus(resultSet.getInt("status"));
                        int exam_id = resultSet.getInt("exam_id");
                        String exam_name = resultSet.getString("exam_name");
                        Timestamp exam_date = resultSet.getTimestamp("exam_date");
                        int time_limits = resultSet.getInt("time_limits");
                        double score = resultSet.getDouble("score");
                        int status = resultSet.getInt("status");
                        System.out.println(status);
                        System.out.println(score);
                        ExamBean exam = new ExamBean(stu_id, exam_id, exam_name, exam_date, time_limits, score, status);
                        examList.add(exam);
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return examList;
    }

    //获取成绩
    @Override
    public double getGrade(String stu_id, String exam_id) {
        try (Connection connection = JDBCUtils.getConnection()) {
            String sql = "SELECT score FROM grades WHERE stu_id = ? and exam_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, stu_id);
                preparedStatement.setString(2, exam_id);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()){
                        return resultSet.getDouble(1);
                    } else {
                        return 0;
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //获取考试科目总数
    @Override
    public int getNumberOfExam(String stu_id) {
        int recordCount = 0;
        String sql = "SELECT COUNT(*) " +
                "FROM users " +
                "LEFT JOIN studentClass ON studentClass.stu_id = users.uid " +
                "LEFT JOIN exams ON studentClass.class_id = exams.class_id " +
                "LEFT JOIN grades ON exams.id = grades.exam_id AND users.uid = grades.stu_id " +
                "LEFT JOIN courses ON exams.course_id = courses.id " +
                "LEFT JOIN studentExamStatus ON exams.id = studentExamStatus.exam_id AND studentExamStatus.stu_id = users.uid " +
                "WHERE users.uid = ? ";
        try (Connection connection = JDBCUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, stu_id);
                try (ResultSet resultSet = preparedStatement.executeQuery()){
                    if (resultSet.next()) {
                        recordCount = resultSet.getInt(1);
                    }
                }
        } catch (SQLException e) {
//            throw new RuntimeException(e);
            e.printStackTrace();
        }

        return recordCount;
    }

    //获取考试列表
    @Override
    public List<ExamBean> getExamList(String stu_id) {
        List<ExamBean> examList = new ArrayList<>();
        try (Connection connection = JDBCUtils.getConnection()) {
            String sql = "SELECT exams.id AS exam_id, exams.name AS exam_name, exam_date, time_limits, score, status " +
                    "FROM users " +
                    "LEFT JOIN studentClass ON studentClass.stu_id = users.uid " +
                    "LEFT JOIN exams ON studentClass.class_id = exams.class_id " +
                    "LEFT JOIN grades ON exams.id = grades.exam_id AND users.uid = grades.stu_id " +
                    "LEFT JOIN courses ON exams.course_id = courses.id " +
                    "LEFT JOIN studentExamStatus ON exams.id = studentExamStatus.exam_id AND studentExamStatus.stu_id = users.uid " +
                    "WHERE users.uid = ? ";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, stu_id);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()){
                        int exam_id = resultSet.getInt("exam_id");
                        String exam_name = resultSet.getString("exam_name");
                        Timestamp exam_date = resultSet.getTimestamp("exam_date");
                        int time_limits = resultSet.getInt("time_limits");
                        double score = resultSet.getDouble("score");
                        int status = resultSet.getInt("status");
                        ExamBean exam = new ExamBean(stu_id, exam_id, exam_name, exam_date, time_limits, score, status);
                        examList.add(exam);
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return examList;
    }

    @Override
    public String getUsername(String stu_id) {
        try (Connection connection = JDBCUtils.getConnection()) {
            String sql = "SELECT username FROM users WHERE uid = ? ";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, stu_id);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()){
                        return resultSet.getString("username");
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "false";
    }
}
