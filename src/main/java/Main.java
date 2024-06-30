 
 public class Main {
    public static void main(String[] args) {
        Lamp lamp1 = new Lamp();
        Lamp lamp2 = lamp1;
        lamp1.turnOn();
        lamp2.turnOff();
        System.out.println(lamp1.isOn);
    }
}
class Lamp {
    boolean isOn;

    void turnOn() {
        isOn = true;
    }

    void turnOff() {
        isOn = false;
    }
}