package utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.Reader;

public class MyBatisUtil {
    private static final Logger LOGGER = Logger.getLogger(MyBatisUtil.class);
    private static final MyBatisUtil myBatisUtil = new MyBatisUtil();
    private static SqlSessionFactory sqlSessionFactory;

    private MyBatisUtil() {
        try {
            Reader reader = Resources.getResourceAsReader("config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSessionFactory getSqlSessionFactory(){
        return sqlSessionFactory;
    }
}