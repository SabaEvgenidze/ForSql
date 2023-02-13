package mybatis;

import dao.ICashierDao;
import models.Cashier;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import utils.MyBatisUtil;

import java.sql.SQLException;

public class CashierServiceImpl implements ICashierDao{
    private static final SqlSessionFactory SESSION_FACTORY = MyBatisUtil.getSqlSessionFactory();
    private static final Logger LOGGER = Logger.getLogger(CashierServiceImpl.class);

    Cashier cashier;

    @Override
    public Cashier selectEntityById(Long id) {

        try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            ICashierDao cashierDao = sqlSession.getMapper(ICashierDao.class);
            cashier = cashierDao.selectEntityById(id);
        } catch (SQLException e) {
            LOGGER.error("SQLException", e);

        }
        return cashier;
    }

    @Override
    public void insertEntity(Cashier entity) {
        try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {

            ICashierDao cashierDao = sqlSession.getMapper(ICashierDao.class);

            try {
                cashierDao.insertEntity(entity);
                sqlSession.commit();

            } catch (SQLException e) {
                sqlSession.rollback();
                LOGGER.error("SQLException", e);

            } catch (Exception e) {
                LOGGER.error("Exception", e);
            }

        }
    }

    @Override
    public void updateEntity(Cashier entity) {
        try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            ICashierDao cashierDao = sqlSession.getMapper(ICashierDao.class);
            try {
                cashierDao.updateEntity(entity);
                sqlSession.commit();
            } catch (SQLException e) {
                sqlSession.rollback();
                LOGGER.error("SQLException", e);
            }
        }

    }

    @Override
    public void deleteEntity(Cashier id) {
        try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            ICashierDao cashierDao = sqlSession.getMapper(ICashierDao.class);

            try {
                cashierDao.deleteEntity(id);
                sqlSession.commit();
            } catch (SQLException e) {
                sqlSession.rollback();
                LOGGER.error("SQLException", e);
            }

        }

    }
}
