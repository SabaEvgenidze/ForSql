package designpatterns.abstractfactory;

import designpatterns.abstractfactory.action.Color;
import designpatterns.abstractfactory.action.Voice;

public class Main {
    public static void main(String [] argv){
        /////VOICE

        AbstractFactory abstractFactory = FactoryGenerator.getFactory("Voice");

        Voice voice = abstractFactory.getVoice("Monkey");
        voice.chooseVoice();

        Voice voice1 = abstractFactory.getVoice("Cat");
        voice1.chooseVoice();

        Voice voice2 = abstractFactory.getVoice("Dog");
        voice2.chooseVoice();


        //////////COLOR

        AbstractFactory abstractFactory1 = FactoryGenerator.getFactory("Color");

        Color color = abstractFactory1.getColor("Black");
        color.chooseColor();

        Color color1 = abstractFactory1.getColor("Brown");
        color1.chooseColor();
    }
}
