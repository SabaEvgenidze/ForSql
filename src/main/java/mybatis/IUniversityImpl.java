package mybatis;

import dao.IUniversityDao;
import models.University;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import utils.MyBatisUtil;

import java.sql.SQLException;

public class IUniversityImpl implements IUniversityDao {
    private static final SqlSessionFactory SESSION_FACTORY = MyBatisUtil.getSqlSessionFactory();
    private static final Logger LOGGER = Logger.getLogger(IAuditorServiceImpl.class);
    University university;

    @Override
    public void insertEntity(University entity) throws SQLException {
        try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            IUniversityDao universityDao = sqlSession.getMapper(IUniversityDao.class);
            try {
                universityDao.insertEntity(entity);
                sqlSession.commit();
            } catch (SQLException e) {
                sqlSession.rollback();
                e.printStackTrace();
            }
        }
    }

    @Override
    public University selectEntityById(Long id) throws SQLException {
        try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            IUniversityDao universityDao = sqlSession.getMapper(IUniversityDao.class);
            university = universityDao.selectEntityById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return university;
    }

    @Override
    public void deleteEntity(University id) throws SQLException {
        try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            IUniversityDao universityDao = sqlSession.getMapper(IUniversityDao.class);
            try {
                universityDao.deleteEntity(id);
                sqlSession.commit();
            } catch (SQLException e) {
                sqlSession.rollback();
                LOGGER.error("SQLException", e);
            }
        }
    }

    @Override
    public void updateEntity(University entity) throws SQLException {
        try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            IUniversityDao universityDao = sqlSession.getMapper(IUniversityDao.class);
            try {
                universityDao.updateEntity(entity);
                sqlSession.commit();
            } catch (SQLException e) {
                sqlSession.rollback();
                e.printStackTrace();
            }
        }
    }
}
