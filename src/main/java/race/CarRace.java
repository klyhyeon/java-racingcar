package race;

public class CarRace {

    private int carCount;

    private int gameCount;

    private String[] carDistance;

    public CarRace() {

    }

    public int getCarCount() {
        return carCount;
    }

    public int getGameCount() {
        return gameCount;
    }

    public static void main(String[] args) {
        CarRace carRace = new CarRace();
        carRace.initGame();
    }

    public void initGame() {
        setGameProfile();
        playGame();
    }


    protected void setGameProfile() {
        carCount = setCarCount();
        gameCount = setGameCount();
        setCarDistance();
    }

    protected int setCarCount() {
       Message.askCarCount();
       return InputView.inputOutput();
    }

    protected int setGameCount() {
        Message.askGameCount();
        return InputView.inputOutput();
    }

    protected void setCarDistance() {
        carDistance = new String[carCount];
        for (int i = 0; i < carCount; i++) {
            carDistance[i] = "";
        }
    }

    private void saveCarMovement() {

    }

    private void playGame() {
        while(gameCount-- > 0) {
            int tempCarCount = 0;
            loopCarCount();
            ResultView.printResult(carDistance);
        }
    }

    private void loopCarCount() {
        int tempCarCount = 0;
        while (tempCarCount < carCount) {
            checkRandomNum(tempCarCount);
            tempCarCount++;
        }
    }

    private void checkRandomNum(int tempCarCount) {
        if (RandomNum.getRandomNum() > 4)
            carDistance[tempCarCount] += "-";
    }

}
