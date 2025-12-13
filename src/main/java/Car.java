public class Car {
    String name;
    int speed;
    int serialNumber;

    Car(String name, int speed, int serialNumber) {
        this.name = name;
        this.speed = speed;
        this.serialNumber = serialNumber;
    }

    public boolean isFaster(Car anotherCar) {
        return this.speed > anotherCar.speed;
    }
}
