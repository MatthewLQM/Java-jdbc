package matthew.jdbc;

import java.sql.*;
import java.text.MessageFormat;

public class MySqlDataSource {
    private static final String PRE_URL = "jdbc:mysql://localhost:3306/";

    public Connection getConnection(String database, String username, String password) {
        String url = MessageFormat.format(PRE_URL + "{0}?serverTimezone=UTC&user={1}&password={2}\\",
                database, username, password);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            LogUtil.log("成功加载MySQL驱动程序");
            return DriverManager.getConnection(url);
//            connection = DriverManager.getConnection(conn_str);
//            Statement statement = connection.createStatement();
//            sql = "show tables;";
//            ResultSet resultSet = statement.executeQuery(sql);
        } catch (ClassNotFoundException e) {
            LogUtil.log("Can not find class com.mysql.jdbc.Driver");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("Error in getConnection()");
    }
}
