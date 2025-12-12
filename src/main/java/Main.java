import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static final int totalOfCars = 3;
    public static final int minSpeed = 0;
    public static final int maxSpeed = 250;

    public static void main(String[] args) {
        System.out.println(String.format("В гонке участвуют %d машины.", totalOfCars));
        ArrayList<Car> cars = new ArrayList<>(totalOfCars);
        for (int currentSerialNumber=1; currentSerialNumber<=totalOfCars; currentSerialNumber++) {
            cars.add(getTrueCarInformationFromUser(currentSerialNumber));
        }
        Race race = new Race(cars);
        Car winnerCar = race.getWinnerCar();
        System.out.println(String.format("К финишу первой пришла машина №%d '%s'.",
                                            winnerCar.serialNumber, winnerCar.name));
    }

    public static Car getTrueCarInformationFromUser(int serialNumber) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(String.format("Введите название машины №%d:", serialNumber));
        String name = scanner.nextLine();
        int speed = 0;
        while (speed<=minSpeed || speed>maxSpeed) {
            System.out.println(String.format("Введите скорость машины (от %d до %d):",
                                             minSpeed, maxSpeed));
            speed = scanner.nextInt();
        }
        Car anotherCar = new Car(name, speed, serialNumber);
        System.out.println(String.format("Машина №%d '%s' со скоростью %d добавлена.",
                                          anotherCar.serialNumber, anotherCar.name, anotherCar.speed));
        return anotherCar;

    }
}

