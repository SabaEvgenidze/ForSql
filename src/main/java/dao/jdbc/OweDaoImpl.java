package dao.jdbc;

import connection.ConnectionPool;
import dao.IOweDao;
import models.Owe;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OweDaoImpl implements IOweDao {
    private static final Logger LOGGER = Logger.getLogger(OweDaoImpl.class);
    ConnectionPool connectionPool = ConnectionPool.getInstance();

    @Override
    public void insertEntity(Owe entity) throws SQLException {
        Connection connection = connectionPool.retrieve();
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO Owe(idOwe, idStudent, amountOfOwe) VALUES(?,?,?)";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, entity.getIdOwe());
            preparedStatement.setLong(2, entity.getIdStudent());
            preparedStatement.setInt(3, entity.getAmountOfOwe());

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                LOGGER.error("Statement cannot close");
                e.printStackTrace();
            }
            if (connection != null) {
                connectionPool.putBack(connection);
            }
        }
    }

    @Override
    public Owe selectEntityById(Long id) throws SQLException {
        Connection connection = connectionPool.retrieve();
        PreparedStatement preparedStatement = null;
        String sql = "SELECT * FROM owe WHERE id=?";
        Owe owe = new Owe();

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            owe.setIdOwe(resultSet.getLong("idOwe"));
            owe.setIdStudent(resultSet.getLong("idStudent"));
            owe.setAmountOfOwe(resultSet.getInt("amountOfOwe"));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                LOGGER.error("Statement cannot close", e);
            }
            if (connection != null) {
                connectionPool.putBack(connection);
            }
        }

        return owe;
    }

    @Override
    public void deleteEntity(Owe entity) throws SQLException {
        Connection connection = connectionPool.retrieve();
        String sql = "DELETE FROM course WHERE idOwe=?";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, entity.getIdOwe());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                LOGGER.error("Statement cannot close", e);
            }
            if (connection != null) {
                connectionPool.putBack(connection);
            }
        }
    }

    @Override
    public void updateEntity(Owe entity) throws SQLException {
        Connection connection = connectionPool.retrieve();
        String sql = "DELETE FROM course WHERE idOwe=?, idStudent=?";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(2, entity.getIdOwe());
            preparedStatement.setLong(1, entity.getIdStudent());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                LOGGER.error("Statement cannot close", e);
            }
            if (connection != null) {
                connectionPool.putBack(connection);
            }
        }
    }
}
