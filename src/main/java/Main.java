import java.util.ArrayList;

public class Main {

    public static int totalOFCars = 3;
    public static  int hoursInRace = 24;
    public static int minSpeedOfVehicle = 0;
    public static int maxSpeedOfVehicle = 250;

    public static void main(String[] args) {
        InteracterWithUserViaConsole interacter = new InteracterWithUserViaConsole();
        ArrayList<Car> cars = interacter.getCarsForRace(totalOFCars, minSpeedOfVehicle, maxSpeedOfVehicle);
        Race race = new Race(cars, hoursInRace);
        Car winCar = race.getWinnerCar();
        interacter.printInformationAboutWinCar(winCar);
    }


}

