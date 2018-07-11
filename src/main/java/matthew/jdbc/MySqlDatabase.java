package matthew.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class MySqlDatabase {

    private Connection connection;

    private MySqlDataSource mySqlDataSource = new MySqlDataSource();

    public MySqlDatabase(String database, String root, String password) {
        connection = mySqlDataSource.getConnection(database, root, password);
    }

    public void resetConnection(String database, String root, String password) {
        try {
            connection.close();
            connection = mySqlDataSource.getConnection(database, root, password);
        } catch (SQLException e) {
            throw new RuntimeException("SQLException", e);
        }
    }

    public ResultSet listAllTable() {
        try {
            Statement statement = connection.createStatement();
            String sql = "show tables;";
            return statement.executeQuery(sql);
        } catch (SQLException e) {
            throw new RuntimeException("SQLException", e);
        }
    }

    public List<Integer> selectIntegerValue(String tableName, String label) {
        try {
            Statement statement = connection.createStatement();
            String sql = MessageFormat.format("select {0} from {1}", label, tableName);
            ResultSet resultSet = statement.executeQuery(sql);
            List<Integer> result = new ArrayList<>();
            while(resultSet.next()) {
                result.add(resultSet.getInt(label));
            }
            return result;
        } catch (SQLException e) {
            throw new RuntimeException("SQLException", e);
        }
    }

    public List<String> selectStringValue(String tableName, String label) {
        try {
            Statement statement = connection.createStatement();
            String sql = MessageFormat.format("select {0} from {1}", label, tableName);
            ResultSet resultSet = statement.executeQuery(sql);
            List<String> result = new ArrayList<>();
            while(resultSet.next()) {
                result.add(resultSet.getString(label));
            }
            return result;
        } catch (SQLException e) {
            throw new RuntimeException("SQLException", e);
        }
    }
}
