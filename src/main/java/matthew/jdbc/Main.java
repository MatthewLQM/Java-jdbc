package matthew.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Main {
    private static String USERNAME = "root";
    private static String PASSWORD = "root";

    public static void main(String[] argv) {
        MySqlDatabase mySqlDatabase = new MySqlDatabase("jdbc", Main.USERNAME, Main.PASSWORD);
        List<String> strings = mySqlDatabase.selectStringValue("id", "id");
        strings.forEach(LogUtil::log);
        LogUtil.log("done");
    }
}
