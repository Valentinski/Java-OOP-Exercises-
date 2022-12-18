package zoo.repositories;

import zoo.entities.foods.Food;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;

public class FoodRepositoryImpl implements FoodRepository{

    private Collection<Food> foods;

    public FoodRepositoryImpl() {
        this.foods=new ArrayList<>();
    }

    @Override
    public void add(Food food) {
        foods.add(food);
    }

    @Override
    public boolean remove(Food food) {
        if(foods.contains(food)){
            foods.remove(food);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Food findByType(String type) {
        return foods.stream()
                .filter(s-> s.getClass().getSimpleName().equals(type))
                .findFirst()
                .orElse(null);
    }
}
