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
    ConnectionPool connectionPoll = ConnectionPool.getInstance();

    @Override
    public void insertEntity(Owe entity) throws SQLException {
        Connection connection = connectionPoll.retrieve();
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
                connectionPoll.putBack(connection);
            }
        }
    }

    @Override
    public Owe selectEntityById(Long id) throws SQLException {
        Connection connection = connectionPoll.retrieve();
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
                connectionPoll.putBack(connection);
            }
        }

        return owe;
    }

    @Override
    public void deleteEntity(Owe entity) throws SQLException {

    }

    @Override
    public void updateEntity(Owe entity) throws SQLException {

    }
}
