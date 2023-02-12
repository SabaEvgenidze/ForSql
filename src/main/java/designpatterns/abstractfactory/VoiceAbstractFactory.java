package designpatterns.abstractfactory;

import designpatterns.abstractfactory.action.Color;
import designpatterns.abstractfactory.action.Voice;

public class VoiceAbstractFactory extends AbstractFactory {
    @Override
    Voice getVoice(String voiceType) {
        if (voiceType == null){
            return null;
        }
        if (voiceType.equalsIgnoreCase("Cat")){
            return new CatForAbstract();
        }else if (voiceType.equalsIgnoreCase("Dog")){
            return new DogForAbstract();
        } else if (voiceType.equalsIgnoreCase("Monkey")) {
            return new MonkeyForAbstract();
        }
        return null;
    }

    @Override
    Color getColor(String colorType) {
        return null;
    }
}
