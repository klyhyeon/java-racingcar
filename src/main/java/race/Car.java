package race;

public class Car {

    private String distance;

    public Car(String input) {
        distance = input;
    }

    public String getDistance() {
        return distance;
    }

    public void addDistance() {
        this.distance += "-";
    }

}
