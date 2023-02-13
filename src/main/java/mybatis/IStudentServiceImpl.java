package mybatis;

import dao.IStudentDao;
import models.Student;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import utils.MyBatisUtil;

import java.sql.SQLException;

public class IStudentServiceImpl implements IStudentDao {
    private static final SqlSessionFactory SESSION_FACTORY = MyBatisUtil.getSqlSessionFactory();
    private static final Logger LOGGER = Logger.getLogger(IAuditorServiceImpl.class);
    Student student;

    @Override
    public void insertEntity(Student entity) throws SQLException {
        try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            IStudentDao studentDao = sqlSession.getMapper(IStudentDao.class);
            try {
                studentDao.insertEntity(entity);
                sqlSession.commit();
            } catch (SQLException e) {
                sqlSession.rollback();
                e.printStackTrace();
            }
        }
    }

    @Override
    public Student selectEntityById(Long id) throws SQLException {
        try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            IStudentDao studentDao = sqlSession.getMapper(IStudentDao.class);
            student = studentDao.selectEntityById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public void deleteEntity(Student id) throws SQLException {
        try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            IStudentDao studentDao = sqlSession.getMapper(IStudentDao.class);
            try {
                studentDao.deleteEntity(id);
                sqlSession.commit();
            } catch (SQLException e) {
                sqlSession.rollback();
                LOGGER.error("SQLException", e);
            }
        }
    }

    @Override
    public void updateEntity(Student entity) throws SQLException {
        try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            IStudentDao studentDao = sqlSession.getMapper(IStudentDao.class);
            try {
                studentDao.updateEntity(entity);
                sqlSession.commit();
            } catch (SQLException e) {
                sqlSession.rollback();
                e.printStackTrace();
            }
        }
    }

}
