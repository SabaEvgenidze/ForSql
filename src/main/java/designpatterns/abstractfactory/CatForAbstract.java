package designpatterns.abstractfactory;

import designpatterns.abstractfactory.action.Voice;
import org.apache.log4j.Logger;

public class CatForAbstract implements Voice {
    private static final Logger LOGGER = Logger.getLogger(CatForAbstract.class);

    @Override
    public void chooseVoice() {
        LOGGER.info("Miau Miau!");
    }
}
