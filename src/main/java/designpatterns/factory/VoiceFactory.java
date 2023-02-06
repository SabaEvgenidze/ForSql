package designpatterns.factory;

import designpatterns.factory.action.IVoice;

public class VoiceFactory {
    public IVoice getVoice(String voiceType) {
        if (voiceType == null) {
            return null;
        }
        if (voiceType.equalsIgnoreCase("Dog")) {
            return new Dog();
        } else if (voiceType.equalsIgnoreCase("Cat")) {
            return new Cat();
        }
        return null;
    }
}
