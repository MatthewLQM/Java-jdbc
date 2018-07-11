package matthew.jdbc;

import java.util.List;

public interface MySqlTable<T extends MySqlObject> {

    void setTableName(String tableName);

    List<T> select(T condition);

    boolean insert(T value);

}
