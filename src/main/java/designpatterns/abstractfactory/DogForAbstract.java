package designpatterns.abstractfactory;

import designpatterns.abstractfactory.action.Voice;
import org.apache.log4j.Logger;

public class DogForAbstract implements Voice {
    private static final Logger LOGGER = Logger.getLogger(DogForAbstract.class);
    @Override
    public void chooseVoice() {
        LOGGER.info("Whoap Whoap!");
    }
}
