package Db_Operation;
import org.liulinger.jdbc.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class Get_Data {
    public Get_Data() {
    }

    public HashMap<String, String> Inquire(String tablename, String username) throws SQLException, ClassNotFoundException {
        Connection connection = new connectMysql().getConnection();
        String sql = "SELECT * FROM " + tablename + " WHERE username = ?" ;
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, username);
        ResultSet resultSet = preparedStatement.executeQuery();
//        String username = null;
        String password = null;
//        String if_login = null;
//        String role = null;
        while (resultSet.next()) {
            //  处理结果集每一行数据
//            username = resultSet.getString("username");
            password = resultSet.getString("password");
//            if_login = resultSet.getString("if_login");
//            role = resultSet.getString("role");
        }
        HashMap<String, String> count = new HashMap<>();
//        count.put("username", username);
        count.put("password", password);
//        count.put("if_login", if_login);
//        count.put("role", role);
        //  关闭有关连接对象
        resultSet.close();
        preparedStatement.close();
        connection.close();
        return count;
    }
}
