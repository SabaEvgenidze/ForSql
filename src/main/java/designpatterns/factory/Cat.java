package designpatterns.factory;

import designpatterns.factory.action.IVoice;
import org.apache.log4j.Logger;

public class Cat implements IVoice {
    private static final Logger LOGGER = Logger.getLogger(Cat.class);
    @Override
    public void voice() {
        LOGGER.info("Miau Miau!");
    }
}
