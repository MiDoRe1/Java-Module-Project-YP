import java.util.ArrayList;
import java.util.Scanner;

public class InteracterWithUserViaConsole {
    public ArrayList<Car> getCarsForRace( int totalOfCars, int minSpeed, int maxSpeed) {
        ArrayList<Car> carsForRace = new ArrayList<>(totalOfCars);
        System.out.println(String.format("В гонке участвуют %d машины.", totalOfCars));
        for (int currentSerialNumber=1; currentSerialNumber<=totalOfCars; currentSerialNumber++) {
            carsForRace.add(getTrueCarInformation(currentSerialNumber, minSpeed, maxSpeed));
        }
        return carsForRace;
    }

    private  Car getTrueCarInformation(int serialNumber, int minSpeed, int maxSpeed) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(String.format("Введите название машины №%d:", serialNumber));
        String name = scanner.nextLine();
        int speed = 0;
        while ( !isValidInformation(speed, minSpeed, maxSpeed)) {
            System.out.println(String.format("Введите скорость машины (%d, %d]:",
                    minSpeed, maxSpeed));
            speed = scanner.nextInt();
        }
        Car anotherCar = new Car(name, speed, serialNumber);
        System.out.println(String.format("Машина №%d '%s' со скоростью %d добавлена.",
                anotherCar.serialNumber, anotherCar.name, anotherCar.speed));
        return anotherCar;
    }

    private boolean isValidInformation(int speed, int minSpeed, int maxSpeed) {
        return speed>minSpeed && speed<=maxSpeed;
    }
    public void printInformationAboutWinCar(Car winCar){
        System.out.println(String.format("К финишу первой пришла машина №%d '%s'.",
                winCar.serialNumber, winCar.name));
    }


}
