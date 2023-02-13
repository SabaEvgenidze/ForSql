package designpatterns.builder;

import org.apache.log4j.Logger;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] argv) {
        Laptop laptop = new Laptop.LaptopBuilder("Lenovo", 8).setIsBluetoothOn(false).setIsSoundOn(true).build();
    }
}
