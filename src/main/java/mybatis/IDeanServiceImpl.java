package mybatis;

import dao.IDeanDao;
import models.Dean;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import utils.MyBatisUtil;

import java.sql.SQLException;

public class IDeanServiceImpl implements IDeanDao {
    private static final SqlSessionFactory SESSION_FACTORY = MyBatisUtil.getSqlSessionFactory();
    private static final Logger LOGGER = Logger.getLogger(IAuditorServiceImpl.class);
    Dean dean;
    @Override
    public void insertEntity(Dean entity) throws SQLException {
        try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            IDeanDao deanDao = sqlSession.getMapper(IDeanDao.class);
            try {
                deanDao.insertEntity(entity);
                sqlSession.commit();
            } catch (SQLException e) {
                sqlSession.rollback();
                e.printStackTrace();
            }
        }
    }

    @Override
    public Dean selectEntityById(Long id) throws SQLException {
        try (SqlSession sqlSession = SESSION_FACTORY.openSession()){
            IDeanDao deanDao = sqlSession.getMapper(IDeanDao.class);
            dean = deanDao.selectEntityById(id);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return dean;
    }

    @Override
    public void deleteEntity(Dean id) throws SQLException {
        try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            IDeanDao deanDao = sqlSession.getMapper(IDeanDao.class);
            try {
                deanDao.deleteEntity(id);
                sqlSession.commit();
            } catch (SQLException e) {
                sqlSession.rollback();
                LOGGER.error("SQLException", e);
            }
        }
    }

    @Override
    public void updateEntity(Dean entity) throws SQLException {
        try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            IDeanDao deanDao = sqlSession.getMapper(IDeanDao.class);
            try {
                deanDao.updateEntity(entity);
                sqlSession.commit();
            } catch (SQLException e) {
                sqlSession.rollback();
                e.printStackTrace();
            }
        }
    }
}
