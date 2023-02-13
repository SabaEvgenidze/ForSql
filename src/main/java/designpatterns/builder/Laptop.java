package designpatterns.builder;

public class Laptop {
    private String name;
    private int RAM;

    private boolean isSoundOn;
    private boolean isBluetoothOn;

    public String getName(String name) {
        return this.name;
    }

    public int getRAM(int RAM) {
        return this.RAM;
    }

    public boolean isSoundOn() {
        return this.isSoundOn;
    }

    public boolean isBluetoothOn() {
        return this.isBluetoothOn;
    }

    public Laptop() {
    }

    public Laptop(String name, int RAM, boolean isBluetoothOn, boolean isSoundOn) {
        this.name = name;
        this.RAM = RAM;
        this.isSoundOn = isSoundOn;
        this.isBluetoothOn = isBluetoothOn;
    }

    public static class LaptopBuilder {
        private String name;
        private int RAM;

        private boolean isSoundOn;
        private boolean isBluetoothOn;

        public LaptopBuilder(String name, int RAM) {
            this.name = name;
            this.RAM = RAM;
        }

        public LaptopBuilder setIsSoundOn(boolean isSoundOn) {
            this.isSoundOn = isSoundOn;
            return this;
        }

        public LaptopBuilder setIsBluetoothOn(boolean isBluetoothOn) {
            this.isBluetoothOn = isBluetoothOn;
            return this;
        }

        public Laptop build() {
            return new Laptop();
        }
    }

}

