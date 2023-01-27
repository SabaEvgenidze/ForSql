package dao;

import java.sql.SQLException;

public interface IBaseDao<T> {
    void insertEntity(T entity) throws SQLException;

    T selectEntityById(Long id) throws SQLException;

    void deleteEntity(T entity) throws SQLException;

    void updateEntity(T entity) throws SQLException;
}
