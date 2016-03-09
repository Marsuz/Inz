package core.persistence;

import java.sql.ResultSet;

/**
 * Created by Marcin on 2016-03-09.
 */
public interface IQueryExecutor {

    public ResultSet executeQuery(String query);

}
