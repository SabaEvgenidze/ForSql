package utils;

import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class DataBaseConfig {
    private static final Logger LOGGER = Logger.getLogger(DataBaseConfig.class);
    private static Properties properties = new Properties();

    static {
        try {
            properties.load(new FileReader("database.properties"));
        } catch (FileNotFoundException e) {
            LOGGER.info("File doesn't exists", e);
        } catch (IOException e) {
            LOGGER.info("IOException", e);
        }
    }
    private DataBaseConfig(){}

    public static Properties getProperties(){
        return properties;
    }
}
