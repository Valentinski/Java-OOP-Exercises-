package zoo.entities.foods;

public class Meat extends BaseFood{

    private final static int CALORIES = 70;
    private final static int PRICE = 10;

    public Meat() {
        super(CALORIES, PRICE);
    }
}