package core.persistence;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marcin on 2016-03-09.
 */

@Component
public class SelectQueryExecutor implements IQueryExecutor {

    private Connection connection;
    private Statement statement;

    final static Logger logger = LoggerFactory.getLogger(SelectQueryExecutor.class);

    public List executeQuery(String query) {

        try {
            connection = DBConnector.getDBConnection();
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(query);
            //ResultSet resultSet = statement.executeQuery("Select * from messages;");
/*            while(resultSet.next()) {
                logger.info(resultSet.getString("id") + " " + resultSet.getString("message"));
            }*/

            return getFormattedResult(resultSet);

        } catch (SQLException e) {

            logger.info("Problem while establishing connection with DB");
            return null;

        } finally {

            try {
                if (statement != null) {
                    statement.close();
                }

                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {

                logger.info("Problem while closing statement/connection!");

            }

        }

    }

    private List<JSONObject> getFormattedResult(ResultSet rs) {
        List<JSONObject> resList = new ArrayList<JSONObject>();
        try {
            ResultSetMetaData rsMeta = rs.getMetaData();
            int columnCnt = rsMeta.getColumnCount();
            List<String> columnNames = new ArrayList<String>();
            for (int i = 1; i <= columnCnt; i++) {
                columnNames.add(rsMeta.getColumnName(i).toUpperCase());
            }

            while (rs.next()) { // convert each object to an human readable JSON object
                JSONObject obj = new JSONObject();
                for (int i = 1; i <= columnCnt; i++) {
                    String key = columnNames.get(i - 1);
                    String value = rs.getString(i);
                    obj.put(key, value);
                }
                resList.add(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return resList;
    }
}
