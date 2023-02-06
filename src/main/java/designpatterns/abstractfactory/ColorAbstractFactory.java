package designpatterns.abstractfactory;

import designpatterns.abstractfactory.action.Color;
import designpatterns.abstractfactory.action.Voice;

public class ColorAbstractFactory extends AbstractFactory {

    @Override
    Color getColor(String colorType) {
        if (colorType == null) {
            return null;
        }
        if (colorType.equalsIgnoreCase("Black")) {
            return new Black();
        } else if (colorType.equalsIgnoreCase("Brown")) {
            return new Brown();
        }
        return null;
    }

    @Override
    Voice getVoice(String voiceType) {
        return null;
    }
}
