package designpatterns.factory;

import designpatterns.factory.action.IVoice;
import designpatterns.factory.VoiceFactory;


public class Main {
    public static void main(String[] argv) {
        ////Factory pattern
        VoiceFactory voiceFactory = new VoiceFactory();

        IVoice voice1 = voiceFactory.getVoice("Dog");
        voice1.voice();

        IVoice voice2 = voiceFactory.getVoice("Cat");
        voice2.voice();
    }
}