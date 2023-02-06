package designpatterns.abstractfactory;

public class FactoryGenerator {
    public static AbstractFactory getFactory(String choice) {
        if (choice.equalsIgnoreCase("Voice")) {
            return new VoiceAbstractFactory();
        } else if (choice.equalsIgnoreCase("Color")) {
            return new ColorAbstractFactory();
        }
        return null;
    }
}
