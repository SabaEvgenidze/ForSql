package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Stack;
import java.util.Vector;

import org.apache.log4j.Logger;

public class ConnectionPool {
    private static final Logger LOGGER = Logger.getLogger(ConnectionPool.class);
    private static final int CON_POOL_SIZE = 5;
    private static final Properties p = new Properties();
    private static final String userName;
    private static final String url;
    private static final String password;
    private Vector<Connection> conPool = new Vector<>(CON_POOL_SIZE, 1);
    private Vector<Connection> activeConnections = new Stack<>();

    private ConnectionPool() {
        for (int i = 0; i < CON_POOL_SIZE; i++) {
            Connection connection = null;
            try {
                connection = DriverManager.getConnection(url, userName, password);
            } catch (SQLException e) {
                LOGGER.info(e);
            }
            conPool.add(connection);
        }
    }

    private static ConnectionPool instance = null;


    public static ConnectionPool getInstance() {
        if (instance == null) instance = new ConnectionPool();
        return instance;
    }

    static {
        try (FileInputStream f = new FileInputStream("C:\\Java\\ForSql\\src\\main\\resources\\database.properties")) {
            p.load(f);
        } catch (IOException e) {
            LOGGER.info(e);
        }
        url = p.getProperty("url");
        userName = p.getProperty("username");
        password = p.getProperty("password");
    }

    private Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, userName, password);
        } catch (Exception e) {
            LOGGER.info(e);
        }
        return conn;
    }

    public synchronized Connection retrieve() {
        Connection newConn = null;
        if (conPool.size() == 0) {
            newConn = getConnection();
        } else {
            newConn = (Connection) conPool.lastElement();
            conPool.removeElement(newConn);
        }
        activeConnections.addElement(newConn);
        LOGGER.info("The connection was retrieved: " + newConn.toString());
        return newConn;
    }

    public synchronized void putBack(Connection c) {
        if (c != null) {
            if (activeConnections.removeElement(c)) {
                conPool.addElement(c);
                LOGGER.info("Putting the connection back to Connection pool: " + c.toString());
            } else {
                throw new NullPointerException("Connection is not in the Active Connections array");
            }
        }
    }
}
