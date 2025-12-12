import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.lang.Math;
public class Race {
    ArrayList<Car> cars;
    Race(ArrayList<Car> cars) {
        this.cars = cars;
    }

    public Car getWinnerCar() {
        Car winnerCar = cars.getFirst();
        for (int i=1; i<cars.size(); i++){
            if (!winnerCar.isFaster(cars.get(i))) winnerCar = cars.get(i);
        }
        return winnerCar;
    }
}
