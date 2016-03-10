package core.persistence;

import org.json.JSONObject;
import java.util.List;

/**
 * Created by Marcin on 2016-03-09.
 */
public interface IQueryExecutor {

    public List executeQuery(String query);

}
