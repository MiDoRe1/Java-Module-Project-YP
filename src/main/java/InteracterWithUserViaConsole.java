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
        String nameOfCar = scanner.nextLine();
        while ( !isValidNameInformation(nameOfCar) ) {
            System.out.println("Невалидный ввод.");
            System.out.println(String.format("Введите название машины №%d:", serialNumber));
            nameOfCar = scanner.nextLine();
        }

        System.out.println(String.format("Введите скорость машины (%d, %d]:",
                minSpeed, maxSpeed));
        String speedOfCarInStringFormat = scanner.nextLine();
        while ( !isValidSpeedInformation(speedOfCarInStringFormat, minSpeed, maxSpeed) ) {
            System.out.println("Невалидный ввод.");
            System.out.println(String.format("Введите скорость машины (%d, %d]:",
                    minSpeed, maxSpeed));
            speedOfCarInStringFormat = scanner.nextLine();
        }

        int speedOfCar = Integer.parseInt(speedOfCarInStringFormat);

        Car anotherCar = new Car(nameOfCar, speedOfCar, serialNumber);
        System.out.println(String.format("Машина №%d '%s' со скоростью %d добавлена.",
                anotherCar.serialNumber, anotherCar.name, anotherCar.speed));
        return anotherCar;
    }

    private boolean isValidNameInformation(String name){

        return !name.isEmpty();
    }

    private boolean isValidSpeedInformation(String speedInStringFormat, int minSpeed, int maxSpeed) {
        Scanner scannerForInt = new Scanner(speedInStringFormat);
        boolean speedIsValid = false;
        if ( scannerForInt.hasNextInt() ) {
            int speed = scannerForInt.nextInt();
            speedIsValid = speed>minSpeed && speed<=maxSpeed;
        }
        return speedIsValid;
    }

    public void printInformationAboutWinCar(Car winCar){
        System.out.println(String.format("К финишу первой пришла машина №%d '%s'.",
                winCar.serialNumber, winCar.name));
    }


}
