package mybatis;

import dao.ICourseDao;
import models.Course;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import utils.MyBatisUtil;

import java.sql.SQLException;

public class ICourseServiceImpl implements ICourseDao {
    private static final SqlSessionFactory SESSION_FACTORY = MyBatisUtil.getSqlSessionFactory();
    private static final Logger LOGGER = Logger.getLogger(IAuditorServiceImpl.class);
    Course course;

    @Override
    public void insertEntity(Course entity) throws SQLException {
        try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            ICourseDao courseDao = sqlSession.getMapper(ICourseDao.class);
            try {
                courseDao.insertEntity(entity);
                sqlSession.commit();
            } catch (SQLException e) {
                sqlSession.rollback();
                e.printStackTrace();
            }
        }
    }

    @Override
    public Course selectEntityById(Long id) throws SQLException {
        try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            ICourseDao courseDao = sqlSession.getMapper(ICourseDao.class);
            course = courseDao.selectEntityById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return course;
    }

    @Override
    public void deleteEntity(Course id) throws SQLException {
        try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            ICourseDao courseDao = sqlSession.getMapper(ICourseDao.class);
            try {
                courseDao.deleteEntity(id);
                sqlSession.commit();
            } catch (SQLException e) {
                sqlSession.rollback();
                LOGGER.error("SQLException", e);
            }
        }
    }

    @Override
    public void updateEntity(Course entity) throws SQLException {
        try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            ICourseDao courseDao = sqlSession.getMapper(ICourseDao.class);
            try {
                courseDao.updateEntity(entity);
                sqlSession.commit();
            } catch (SQLException e) {
                sqlSession.rollback();
                e.printStackTrace();
            }
        }
    }
}
