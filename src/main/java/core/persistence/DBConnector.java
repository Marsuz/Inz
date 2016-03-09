package core.persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Marcin on 2016-03-09.
 */
public class DBConnector {

    private static final String JDBC_DRIVER = "org.postgresql.Driver";
    private static String DB_URL = "jdbc:postgresql://localhost:5433/dbone";
    private static String user = "postgres";
    private static String password = "1234";

    final static Logger logger = LoggerFactory.getLogger(DBConnector.class);

    public static Connection getDBConnection() {

        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            logger.info("JDBC driver not found");
        }

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(DB_URL, user, password);
        } catch (SQLException e) {
            logger.info("Could not establish connection with database");
        }

        return connection;

    }

}
