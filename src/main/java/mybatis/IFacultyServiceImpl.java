package mybatis;

import dao.IFacultyDao;
import models.Faculty;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import utils.MyBatisUtil;

import java.sql.SQLException;

public class IFacultyServiceImpl implements IFacultyDao {
    private static final SqlSessionFactory SESSION_FACTORY = MyBatisUtil.getSqlSessionFactory();
    private static final Logger LOGGER = Logger.getLogger(IAuditorServiceImpl.class);
    Faculty faculty;

    @Override
    public void insertEntity(Faculty entity) throws SQLException {
        try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            IFacultyDao facultyDao = sqlSession.getMapper(IFacultyDao.class);
            try {
                facultyDao.insertEntity(entity);
                sqlSession.commit();
            } catch (SQLException e) {
                sqlSession.rollback();
                e.printStackTrace();
            }
        }
    }

    @Override
    public Faculty selectEntityById(Long id) throws SQLException {
        try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            IFacultyDao facultyDao = sqlSession.getMapper(IFacultyDao.class);
            faculty = facultyDao.selectEntityById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return faculty;
    }

    @Override
    public void deleteEntity(Faculty id) throws SQLException {
        try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            IFacultyDao facultyDao = sqlSession.getMapper(IFacultyDao.class);
            try {
                facultyDao.deleteEntity(id);
                sqlSession.commit();
            } catch (SQLException e) {
                sqlSession.rollback();
                LOGGER.error("SQLException", e);
            }
        }
    }

    @Override
    public void updateEntity(Faculty entity) throws SQLException {
        try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            IFacultyDao facultyDao = sqlSession.getMapper(IFacultyDao.class);
            try {
                facultyDao.updateEntity(entity);
                sqlSession.commit();
            } catch (SQLException e) {
                sqlSession.rollback();
                e.printStackTrace();
            }
        }
    }
}
