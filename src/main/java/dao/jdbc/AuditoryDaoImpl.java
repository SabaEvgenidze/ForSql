package dao.jdbc;

import utils.ConnectionPool;
import dao.IAuditoryDao;
import models.Auditory;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuditoryDaoImpl implements IAuditoryDao {
    private static final Logger LOGGER = Logger.getLogger(AuditoryDaoImpl.class);

    ConnectionPool connectionPool = ConnectionPool.getInstance();

    public void insertEntity(Auditory entity) throws SQLException {
        Connection connection = connectionPool.retrieve();
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO Auditory(idAuditory, idUniversity, capacity) VALUES(?,?,?)";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, entity.getIdAuditory());
            preparedStatement.setLong(2, entity.getIdUniversity());
            preparedStatement.setInt(3, entity.getCapacity());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connectionPool.putBack(connection);
                System.out.println("Connection returned successfully");
            }
        }
    }

    @Override
    public Auditory selectEntityById(Long id) throws SQLException {
        Connection connection = connectionPool.retrieve();
        PreparedStatement statement = null;
        String sql = "SELECT * FROM AuditoryDao WHERE idAuditory = ?";
        Auditory auditory = new Auditory();

        try {
            statement = connection.prepareStatement(sql);

            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();

            auditory.setIdAuditory(resultSet.getLong("idAuditory"));
            auditory.setIdUniversity(resultSet.getLong("idUniversity"));
            auditory.setCapacity(resultSet.getInt("capacity"));

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                    LOGGER.info("Statement closed successfully");
                }
            } catch (SQLException e) {
                LOGGER.error("cannot close statement", e);
            }
            if (connection != null) {
                connectionPool.putBack(connection);
                System.out.println("Connection returned successfully");
            }
        }
        return auditory;
    }

    @Override
    public void deleteEntity(Auditory entity) throws SQLException {
        Connection connection = connectionPool.retrieve();
        String sql = "DELETE FROM auditory WHERE idAuditory=?";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, entity.getIdAuditory());
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
    public void updateEntity(Auditory entity) throws SQLException {
        Connection connection = connectionPool.retrieve();
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE auditory set idAuditory=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, entity.getIdAuditory());
            preparedStatement.setLong(2, entity.getIdUniversity());

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
