package zoo.entities.foods;

public class Vegetable extends BaseFood{

    private final static int CALORIES = 50;
    private final static int PRICE = 5;

    public Vegetable() {
        super(CALORIES, PRICE);
    }
}
