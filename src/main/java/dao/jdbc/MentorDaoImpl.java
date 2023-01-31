package dao.jdbc;

import utils.ConnectionPool;
import dao.IMentorDao;
import models.Mentor;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MentorDaoImpl implements IMentorDao {
    private static final Logger LOGGER = Logger.getLogger(MentorDaoImpl.class);
    ConnectionPool connectionPool = ConnectionPool.getInstance();

    @Override
    public void insertEntity(Mentor entity) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO mentor(idMentor, idUniversity, name, surname, age, gender) values(?,?,?,?,?,?)";
        Connection connection = connectionPool.retrieve();

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, entity.getIdMentor());
            preparedStatement.setLong(2, entity.getIdUniversity());
            preparedStatement.setString(3, entity.getName());
            preparedStatement.setString(4, entity.getSurname());
            preparedStatement.setInt(5, entity.getAge());
            preparedStatement.setString(6, entity.getGender());
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
    public Mentor selectEntityById(Long id) throws SQLException {
        Connection connection = connectionPool.retrieve();
        PreparedStatement preparedStatement = null;
        String sql = "SELECT * FROM mentor WHERE id=?";
        Mentor mentor = new Mentor();

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            mentor.setIdMentor(resultSet.getLong("idMentor"));
            mentor.setIdUniversity(resultSet.getLong("idUniversity"));
            mentor.setName(resultSet.getString("name"));
            mentor.setSurname(resultSet.getString("surname"));
            mentor.setAge(resultSet.getInt("age"));
            mentor.setGender(resultSet.getString("gender"));

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
        return mentor;
    }

    @Override
    public void deleteEntity(Mentor entity) throws SQLException {
        Connection connection = connectionPool.retrieve();
        String sql = "DELETE FROM course WHERE idMentor=?";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, entity.getIdMentor());
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
    public void updateEntity(Mentor entity) throws SQLException {
        Connection connection = connectionPool.retrieve();
        String sql = "DELETE FROM course WHERE idMentor=?, idUniversity=?";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(2, entity.getIdMentor());
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
