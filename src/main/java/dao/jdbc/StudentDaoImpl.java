package dao.jdbc;

import utils.ConnectionPool;
import dao.IStudentDao;
import models.Student;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDaoImpl implements IStudentDao {
    private static final Logger LOGGER = Logger.getLogger(StudentDaoImpl.class);
    ConnectionPool connectionPool = ConnectionPool.getInstance();


    @Override
    public void insertEntity(Student entity) throws SQLException {
        Connection connection = connectionPool.retrieve();
        String sql = "INSERT INTO Student(idStudent, idUniversity, idFaculty, name, surname, gender, age) VALUES(?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, entity.getIdStudent());
            preparedStatement.setLong(2, entity.getIdStudent());
            preparedStatement.setString(3, entity.getName());
            preparedStatement.setString(4, entity.getSurname());
            preparedStatement.setString(5, entity.getGender());
            preparedStatement.setInt(6, entity.getAge());
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
                connection.close();
            }
        }
    }

    @Override
    public Student selectEntityById(Long id) throws SQLException {
        Connection connection = connectionPool.retrieve();
        PreparedStatement preparedStatement = null;
        String sql = "SELECT * FROM student WHERE id=?";
        Student student = new Student();

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            student.setIdStudent(resultSet.getLong("idStudent"));
            student.setIdUniversity(resultSet.getLong("idUniversity"));
            student.setIdFaculty(resultSet.getLong("idFaculty"));
            student.setName(resultSet.getString("name"));
            student.setSurname(resultSet.getString("surname"));
            student.setAge(resultSet.getInt("age"));
            student.setGender(resultSet.getString("gender"));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                LOGGER.error("statement cannot close");
            }
            if (connection != null) {
                connectionPool.putBack(connection);
            }
        }

        return student;
    }

    @Override
    public void deleteEntity(Student id) throws SQLException {
        Connection connection = connectionPool.retrieve();
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM student where id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id.getIdStudent());
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
    public void updateEntity(Student entity) throws SQLException {
        Connection connection = connectionPool.retrieve();
        String sql = "UPDATE student SET  idStudent=?, idUniversity=?, idFaculty=?";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, entity.getIdStudent());
            preparedStatement.setLong(2, entity.getIdUniversity());
            preparedStatement.setLong(3, entity.getIdFaculty());

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
