package core.persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Marcin on 2016-03-09.
 */

@Component
public class SelectQueryExecutor implements IQueryExecutor {

    private Connection connection;
    private Statement statement;

    final static Logger logger = LoggerFactory.getLogger(SelectQueryExecutor.class);

    public ResultSet executeQuery(String query) {

        try {
            connection = DBConnector.getDBConnection();
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(query);

            return resultSet;

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
}
