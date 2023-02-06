package designpatterns.abstractfactory;

import designpatterns.abstractfactory.action.Voice;
import org.apache.log4j.Logger;

public class MonkeyForAbstract implements Voice {
    private static final Logger LOGGER = Logger.getLogger(MonkeyForAbstract.class);
    @Override
    public void chooseVoice() {
        LOGGER.info("Makaka :)");
    }
}
