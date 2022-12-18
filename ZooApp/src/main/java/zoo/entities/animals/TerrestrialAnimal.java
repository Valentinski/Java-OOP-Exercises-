package zoo.entities.animals;

public class TerrestrialAnimal extends BaseAnimal{

    //Can only live in LandArea!
    private final static double INITIAL_KILOGRAMS = 5.50;

    public TerrestrialAnimal(String name, String kind, double price) {
        super(name, kind, INITIAL_KILOGRAMS, price);
    }

    @Override
    public void eat() {
        double increasedKg = INITIAL_KILOGRAMS + 5.7;
        setKg(increasedKg);
    }
}
