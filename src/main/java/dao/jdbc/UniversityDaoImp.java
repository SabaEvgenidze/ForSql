package dao.jdbc;

import connection.ConnectionPool;
import dao.IUniversityDao;
import models.University;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UniversityDaoImp implements IUniversityDao {
    private static final Logger LOGGER = Logger.getLogger(UniversityDaoImp.class);
    ConnectionPool connectionPool = ConnectionPool.getInstance();

    public void insertEntity(University entity) throws SQLException {
        Connection connection = connectionPool.retrieve();
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO University(idUniversity, name, location) values (?,?,?)";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, entity.getIdUniversity());
            preparedStatement.setString(2, entity.getName());
            preparedStatement.setInt(3, entity.getLocation());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                LOGGER.error("statement cannot close", e);
            }
            if (connection != null) {
                connectionPool.putBack(connection);
            }
        }
    }

    @Override
    public University selectEntityById(Long id) throws SQLException {
        Connection connection = connectionPool.retrieve();
        PreparedStatement preparedStatement = null;
        String sql = "SELECT * FROM university WHERE id=?";
        University university = new University();

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            university.setIdUniversity(resultSet.getLong("idUniversity"));
            university.setName(resultSet.getString("name"));
            university.setLocation(resultSet.getInt("location"));

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

        return university;
    }

    public void deleteEntity(University entity) throws SQLException {
        Connection connection = connectionPool.retrieve();
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM University WHERE idUniversity=? ";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, entity.getIdUniversity());
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

    public void updateEntity(University entity) throws SQLException {
        Connection connection = connectionPool.retrieve();
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE university SET idUniversity = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, entity.getIdUniversity());

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
