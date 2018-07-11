package matthew.jdbc;

import java.sql.*;

public class App {
    public static void main(String[] args) throws SQLException {
        System.out.println("Hello World");
        Connection connection = null;
        String sql;
        String conn_str = "jdbc:mysql://localhost:3306/mysql?serverTimezone=UTC&user=root&password=root/";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("成功加载MySQL驱动程序");
            connection = DriverManager.getConnection(conn_str);
            Statement statement = connection.createStatement();
            sql = "show tables;";
            ResultSet resultSet = statement.executeQuery(sql);
            if(resultSet != null) {
                while (resultSet.next()) {
                    System.out.println(resultSet.getString(1) + '\t');
                }
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Can not find class com.mysql.jdbc.Driver");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }

    }
}
