package designpatterns.abstractfactory;

import designpatterns.abstractfactory.action.Color;
import designpatterns.abstractfactory.action.Voice;

public abstract class AbstractFactory {
    abstract Voice getVoice(String voiceType);
    abstract Color getColor(String colorType);
}
