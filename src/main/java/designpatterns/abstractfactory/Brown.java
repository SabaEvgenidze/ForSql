package designpatterns.abstractfactory;

import designpatterns.abstractfactory.action.Color;
import org.apache.log4j.Logger;

public class Brown implements Color {
    private static final Logger LOGGER = Logger.getLogger(Brown.class);
    @Override
    public void chooseColor() {
        LOGGER.info("I choose brown");
    }
}
