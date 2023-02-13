package dao.jdbc;

import utils.ConnectionPool;
import dao.IStaffDao;
import models.Staff;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;


public class StaffDaoImpl implements IStaffDao {
    private static final Logger LOGGER = Logger.getLogger(StaffDaoImpl.class);
    ConnectionPool connectionPool = ConnectionPool.getInstance();

    @Override
    public void insertEntity(Staff entity) throws SQLException {
        Connection connection = connectionPool.retrieve();
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO Staff (idStaff, idUniversity, name, surname, age) Values (?,?,?,?,?)";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, entity.getIdStaff());
            preparedStatement.setLong(2, entity.getIdUniversity());
            preparedStatement.setString(3, entity.getName());
            preparedStatement.setString(4, entity.getSurname());
            preparedStatement.setInt(5, entity.getAge());
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
    public Staff selectEntityById(Long id) throws SQLException {
        Connection connection = connectionPool.retrieve();
        PreparedStatement preparedStatement = null;
        String sql = "SELECT * FROM staff WHERE id=?";
        Staff staff = new Staff();

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            staff.setIdStaff(resultSet.getLong("idStaff"));
            staff.setIdUniversity(resultSet.getLong("idUniversity"));
            staff.setName(resultSet.getString("name"));
            staff.setSurname(resultSet.getString("surname"));
            staff.setAge(resultSet.getInt("age"));

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

        return staff;
    }

    @Override
    public void deleteEntity(Staff id) throws SQLException {
        Connection connection = connectionPool.retrieve();
        String sql = "DELETE FROM course WHERE idStaff=?";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id.getIdStaff());
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
    public void updateEntity(Staff entity) throws SQLException {
        Connection connection = connectionPool.retrieve();
        String sql = "DELETE FROM course WHERE idStaff=?, idUniversity=?";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(2, entity.getIdStaff());
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
