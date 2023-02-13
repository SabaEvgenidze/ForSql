package mybatis;

import dao.IAuditoryDao;
import models.Auditory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import utils.MyBatisUtil;

import java.sql.SQLException;

public class IAuditorServiceImpl implements IAuditoryDao {
    private static final SqlSessionFactory SESSION_FACTORY = MyBatisUtil.getSqlSessionFactory();
    private static final Logger LOGGER = Logger.getLogger(IAuditorServiceImpl.class);
    Auditory auditory;


    @Override
    public void insertEntity(Auditory entity) throws SQLException {
        try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            IAuditoryDao auditoryDao = sqlSession.getMapper(IAuditoryDao.class);
            try {
                auditoryDao.insertEntity(entity);
                sqlSession.commit();
            } catch (SQLException e) {
                sqlSession.rollback();
                e.printStackTrace();
            }
        }
    }

    @Override
    public Auditory selectEntityById(Long id) throws SQLException {
        try (SqlSession sqlSession = SESSION_FACTORY.openSession()){
            IAuditoryDao auditoryDao = sqlSession.getMapper(IAuditoryDao.class);
            auditory = auditoryDao.selectEntityById(id);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return auditory;
    }

    @Override
    public void deleteEntity(Auditory id) throws SQLException {
        try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            IAuditoryDao auditoryDao = sqlSession.getMapper(IAuditoryDao.class);
            try {
                auditoryDao.deleteEntity(id);
                sqlSession.commit();
            } catch (SQLException e) {
                sqlSession.rollback();
                LOGGER.error("SQLException", e);
            }
        }
    }

    @Override
    public void updateEntity(Auditory entity) throws SQLException {
        try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            IAuditoryDao auditoryDao = sqlSession.getMapper(IAuditoryDao.class);
            try {
                auditoryDao.updateEntity(entity);
                sqlSession.commit();
            } catch (SQLException e) {
                sqlSession.rollback();
                e.printStackTrace();
            }
        }
    }
}
