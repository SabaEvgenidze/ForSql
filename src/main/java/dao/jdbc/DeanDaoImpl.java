package dao.jdbc;

import connection.ConnectionPool;
import dao.IDeanDao;
import models.Dean;
import org.apache.log4j.Logger;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeanDaoImpl implements IDeanDao {
    private static final Logger LOGGER = Logger.getLogger(DeanDaoImpl.class);
    ConnectionPool connectionPool = ConnectionPool.getInstance();

    public void insertEntity(Dean entity) throws SQLException {
        Connection connection = connectionPool.retrieve();
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO Dean(idDean, idMentor, name, surname, gender, age) VALUES(?,?,?,?)";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, entity.getIdDean());
            preparedStatement.setLong(2, entity.getIdMentor());
            preparedStatement.setString(3, entity.getName());
            preparedStatement.setString(4, entity.getSurname());
            preparedStatement.setString(5, entity.getGender());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (connection != null) {
                connectionPool.putBack(connection);
            }
        }
    }

    @Override
    public Dean selectEntityById(Long id) throws SQLException {
        Connection connection = connectionPool.retrieve();
        PreparedStatement preparedStatement = null;
        String sql = "SELECT * FROM dean WHERE idDean=?";
        Dean dean = new Dean();

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            dean.setIdDean(resultSet.getLong("idDean"));
            dean.setIdMentor(resultSet.getLong("idMentor"));
            dean.setName(resultSet.getString("name"));
            dean.setSurname(resultSet.getString("surname"));
            dean.setGender(resultSet.getString("gender"));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                LOGGER.error("Statement cannot closed", e);
            }
            if (connection != null) {
                connectionPool.putBack(connection);
            }
        }

        return dean;
    }

    @Override
    public void deleteEntity(Dean entity) throws SQLException {

    }

    @Override
    public void updateEntity(Dean entity) throws SQLException {

    }
}
