package dao.jdbc;

import utils.ConnectionPool;
import dao.IFacultyDao;
import models.Faculty;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class FacultyDaoImpl implements IFacultyDao {
    private static final Logger LOGGER = Logger.getLogger(FacultyDaoImpl.class);
    ConnectionPool connectionPool = ConnectionPool.getInstance();

    @Override
    public void insertEntity(Faculty entity) throws SQLException {
        Connection connection = connectionPool.retrieve();
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO faculty(idFaculty, idDean, idCourse, name) VALUES (?,?,?,?)";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, entity.getIdFaculty());
            preparedStatement.setLong(2, entity.getIdDean());
            preparedStatement.setLong(3, entity.getIdCourse());
            preparedStatement.setString(4, entity.getName());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                LOGGER.error("statement cannot close!", e);
            }
            if (connection != null) {
                connectionPool.putBack(connection);
            }
        }
    }

    @Override
    public Faculty selectEntityById(Long id) throws SQLException {
        Connection connection = connectionPool.retrieve();
        PreparedStatement preparedStatement = null;
        String sql = "SELECT * FROM faculty WHERE idFaculty=?";
        Faculty faculty = new Faculty();

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            faculty.setIdFaculty(resultSet.getLong("idFaculty"));
            faculty.setIdCourse(resultSet.getLong("idCourse"));
            faculty.setIdDean(resultSet.getLong("idDean"));
            faculty.setName(resultSet.getString("name"));

            preparedStatement.executeUpdate();
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
        return faculty;
    }

    @Override
    public void deleteEntity(Faculty entity) throws SQLException {
        Connection connection = connectionPool.retrieve();
        String sql = "DELETE FROM course WHERE idFaculty=?";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, entity.getIdFaculty());
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
    public void updateEntity(Faculty entity) throws SQLException {
        Connection connection = connectionPool.retrieve();
        String sql = "DELETE FROM course WHERE idDean=?, idCourse=?, idFaculty";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(2, entity.getIdFaculty());
            preparedStatement.setLong(1, entity.getIdDean());
            preparedStatement.setLong(2, entity.getIdCourse());

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
