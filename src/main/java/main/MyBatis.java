package main;

import dao.ICashierDao;
import models.Cashier;
import mybatis.CashierServiceImpl;
import org.apache.log4j.Logger;

import java.sql.SQLException;

public class MyBatis {
    private static final Logger LOGGER = Logger.getLogger(MyBatis.class);

    public static void main(String[] argv) throws SQLException {
        ICashierDao cashierDao = new CashierServiceImpl();
        LOGGER.info(cashierDao.selectEntityById(2L));

        Cashier object = new Cashier(6L, 1L);
        cashierDao.insertEntity(object);
    }
}
