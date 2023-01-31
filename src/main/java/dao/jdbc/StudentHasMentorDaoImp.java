package dao.jdbc;

import utils.ConnectionPool;
import dao.IStudentHasMentorDao;
import models.StudentHasMentor;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentHasMentorDaoImp implements IStudentHasMentorDao {
    private static final Logger LOGGER = Logger.getLogger(StudentDaoImpl.class);
    ConnectionPool connectionPool = ConnectionPool.getInstance();

    @Override
    public void insertEntity(StudentHasMentor entity) throws SQLException {
        Connection connection = connectionPool.retrieve();
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO StudentHasMentor(idStudent, idMentor) VALUES (?,?) ";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, entity.getIdMentor());
            preparedStatement.setLong(2, entity.getIdStudent());
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
    public StudentHasMentor selectEntityById(Long id) throws SQLException {
        Connection connection = connectionPool.retrieve();
        PreparedStatement preparedStatement = null;
        String sql = "SELECT * FROM studentHasMentor WHERE id=?";
        StudentHasMentor studentHasMentor = new StudentHasMentor();

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            studentHasMentor.setIdMentor(resultSet.getLong("idMentor"));
            studentHasMentor.setIdStudent(resultSet.getLong("idStudent"));

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

        return studentHasMentor;
    }


    @Override
    public void deleteEntity(StudentHasMentor entity) throws SQLException {
        Connection connection = connectionPool.retrieve();
        String sql = "DELETE FROM course WHERE idStudent=?, idMentor=?";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, entity.getIdStudent());
            preparedStatement.setLong(2, entity.getIdMentor());
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
    public void updateEntity(StudentHasMentor entity) throws SQLException {
        Connection connection = connectionPool.retrieve();
        String sql = "UPDATE student SET  idStudent=?, idMentor=?";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, entity.getIdStudent());
            preparedStatement.setLong(2, entity.getIdMentor());

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

