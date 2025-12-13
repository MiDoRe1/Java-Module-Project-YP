import java.util.ArrayList;
public class Race {
    ArrayList<Car> cars;
    int hoursInRace;


    Race(ArrayList<Car> cars,  int hoursInRace) {
        this.cars = cars;
        this.hoursInRace = hoursInRace;
    }


    public Car getWinnerCar() {
        Car winnerCar = cars.getFirst();
        for (int i=1; i<cars.size(); i++){
            if (!winnerCar.isFaster(cars.get(i))) winnerCar = cars.get(i);
        }
        return winnerCar;
    }
}
