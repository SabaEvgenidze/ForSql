package designpatterns.factory;

import designpatterns.factory.action.IVoice;
import org.apache.log4j.Logger;

public class Dog implements IVoice {
    private static final Logger LOGGER = Logger.getLogger(Dog.class);
    @Override
    public void voice() {
        LOGGER.info("Whoap Whoap");
    }
}
