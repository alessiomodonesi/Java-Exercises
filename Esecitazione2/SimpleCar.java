public class SimpleCar {
    private int gear;
    private final static int MIN_GEAR = 0;
    private final static int MAX_GEAR = 6;

    private double speed;
    private final static double INITIAL_SPEED = 10;
    private final static double SPEED_DECREMENT_PERCENT = 0.7;
    private final static double SPEED_INCREMENT_PERCENT = 1.5;

    public SimpleCar() {
        this.gear = 0;
        this.speed = 0;
    }

    public void speedUp() {
        if (speed == 0)
            speed = INITIAL_SPEED;
        else
            speed *= SPEED_INCREMENT_PERCENT;
    }

    public void brake() {
        if (speed != 0)
            speed *= SPEED_DECREMENT_PERCENT;
    }

    public void gearUp() {
        if (gear < MAX_GEAR)
            gear++;
    }

    public void gearDown() {
        if (gear > MIN_GEAR)
            gear--;
    }

    public java.lang.String toString() {
        return String.format("SimpleCar: marcia = %d, velocità = %.2f km/h", gear, speed);
    }
}
