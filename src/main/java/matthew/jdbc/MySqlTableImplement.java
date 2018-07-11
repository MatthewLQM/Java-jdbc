package matthew.jdbc;

import java.util.List;

public class MySqlTableImplement<T extends MySqlObject> implements MySqlTable<T> {

    private String tableName;

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<T> select(T condition) {
        return null;
    }

    public boolean insert(T value) {
        return true;
    }

    public String getTableName() {
        return this.tableName;
    }

}
