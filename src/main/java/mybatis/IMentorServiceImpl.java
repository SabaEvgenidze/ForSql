package mybatis;

import dao.IFacultyDao;
import dao.IMentorDao;
import models.Faculty;
import models.Mentor;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import utils.MyBatisUtil;

import java.sql.SQLException;

public class IMentorServiceImpl implements IMentorDao {
    private static final SqlSessionFactory SESSION_FACTORY = MyBatisUtil.getSqlSessionFactory();
    private static final Logger LOGGER = Logger.getLogger(IAuditorServiceImpl.class);
    Mentor mentor;
    @Override
    public void insertEntity(Mentor entity) throws SQLException {
        try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            IMentorDao mentorDao = sqlSession.getMapper(IMentorDao.class);
            try {
                mentorDao.insertEntity(entity);
                sqlSession.commit();
            } catch (SQLException e) {
                sqlSession.rollback();
                e.printStackTrace();
            }
        }
    }

    @Override
    public Mentor selectEntityById(Long id) throws SQLException {
        try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            IMentorDao mentorDao = sqlSession.getMapper(IMentorDao.class);
            mentor = mentorDao.selectEntityById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mentor;
    }

    @Override
    public void deleteEntity(Mentor id) throws SQLException {
        try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            IMentorDao mentorDao = sqlSession.getMapper(IMentorDao.class);
            try {
                mentorDao.deleteEntity(id);
                sqlSession.commit();
            } catch (SQLException e) {
                sqlSession.rollback();
                LOGGER.error("SQLException", e);
            }
        }
    }

    @Override
    public void updateEntity(Mentor entity) throws SQLException {
        try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            IMentorDao mentorDao = sqlSession.getMapper(IMentorDao.class);
            try {
                mentorDao.updateEntity(entity);
                sqlSession.commit();
            } catch (SQLException e) {
                sqlSession.rollback();
                e.printStackTrace();
            }
        }
    }
}
