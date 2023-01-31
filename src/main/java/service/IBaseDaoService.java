package service;

import java.sql.SQLException;

public interface IBaseDaoService<T> {
    void insert(T entity) throws SQLException;

    void delete(T entity) throws SQLException;

    void update(T entity) throws SQLException;

    T selectEntityById(Long id) throws SQLException;

}
