package zoo.entities.animals;

public class AquaticAnimal extends BaseAnimal{
    //Can only live in WaterArea!
    private final static double INITIAL_KILOGRAMS = 2.50;

    public AquaticAnimal(String name, String kind, double price) {
        super(name, kind, INITIAL_KILOGRAMS, price);
    }

    @Override
    public void eat() {
        double increasedKg = INITIAL_KILOGRAMS + 7.5;
        setKg(increasedKg);
    }
}
