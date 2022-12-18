package zoo.entities.areas;

import zoo.entities.animals.Animal;
import zoo.entities.animals.TerrestrialAnimal;
import zoo.entities.foods.BaseFood;
import zoo.entities.foods.Food;

public class LandArea extends BaseArea{

    private final static  int CAPACITY = 25;

    public LandArea(String name) {
        super(name, CAPACITY);
    }

}
