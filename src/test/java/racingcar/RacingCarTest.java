package racingcar;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    String[] carNames = {"john", "tom", "myung"};
    Car car = new Car();

    @BeforeAll
    static void beforeAll() {
        Car car = new Car();
    }

    @DisplayName("차량셋팅")
    @Test
    void initCar() {
        CarRace carRace = new CarRace(carNames, 5);
        assertThat(carRace.getCars()).hasSize(3);
    }

    @DisplayName("우승자확인")
    @Test
    void getWinnerCarsTest() {
        CarRace carRace = new CarRace(carNames, 3);
        Car car = new Car("test");
        car.go(10);
        car.go(10);
        Car car2 = new Car("test2");
        car2.go(10);
        ArrayList<CarSnapshot> carSnapshotArrayList = new ArrayList<>();
        carSnapshotArrayList.add(car.snapshot());
        RaceSnapshot raceSnapshot = new RaceSnapshot(carSnapshotArrayList);
        ArrayList<RaceSnapshot> raceSnapshotArrayList = new ArrayList<>();
        raceSnapshotArrayList.add(raceSnapshot);
        carRace.setRaceResult(raceSnapshotArrayList);
        List<Car> winnerCars = carRace.getWinnerCars();
        assertThat(winnerCars.get(0).getName()).isEqualTo("test");
    }
}
