package dao.jdbc;

import utils.ConnectionPool;
import dao.ICourseDao;
import models.Course;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CourseDaoImp implements ICourseDao {
    private static final Logger LOGGER = Logger.getLogger(CourseDaoImp.class);
    ConnectionPool connectionPool = ConnectionPool.getInstance();

    public void insertEntity(Course entity) throws SQLException {
        Connection connection = connectionPool.retrieve();
        PreparedStatement statement = null;
        String sql = "INSERT INTO Course(idCourse, name, course) VALUES(?,?,?)";

        try {
            statement = connection.prepareStatement(sql);

            statement.setLong(1, entity.getIdCourse());
            statement.setString(2, entity.getName());
            statement.setInt(3, entity.getCourse());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                LOGGER.error("Statement don't close", e);
            }
            if (connection != null) {
                connectionPool.putBack(connection);
            }
        }
    }

    @Override
    public Course selectEntityById(Long id) throws SQLException {
        Connection connection = connectionPool.retrieve();
        PreparedStatement preparedStatement = null;
        String sql = "SELECT * FROM course WHERE idCourse=?";
        Course course = new Course();

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            course.setIdCourse(resultSet.getLong("idCourse"));
            course.setCourse(resultSet.getInt("course"));
            course.setName(resultSet.getString("name"));

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
                LOGGER.info("Connection returned successfully");
            }
        }


        return course;
    }

    @Override
    public void deleteEntity(Course id) throws SQLException {
        Connection connection = connectionPool.retrieve();
        String sql = "DELETE FROM course WHERE idCourse=?";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id.getIdCourse());
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
    public void updateEntity(Course entity) throws SQLException {
        Connection connection = connectionPool.retrieve();
        String sql = "DELETE FROM course WHERE idCourse=?, ";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, entity.getIdCourse());

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
