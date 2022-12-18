package zoo.entities.areas;

import zoo.entities.animals.Animal;
import zoo.entities.foods.BaseFood;
import zoo.entities.foods.Food;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static zoo.common.ExceptionMessages.AREA_NAME_NULL_OR_EMPTY;
import static zoo.common.ExceptionMessages.NOT_ENOUGH_CAPACITY;

public abstract class BaseArea implements Area {

    private String name;
    private int capacity;
    private Collection<Food> foods;
    private Collection<Animal> animals;

    protected BaseArea(String name, int capacity) {
        setName(name);
        setCapacity(capacity);
        this.foods = new ArrayList<>();
        this.animals = new ArrayList<>();
    }

    @Override
    public int sumCalories() {
        return foods.stream()
                .mapToInt(Food::getCalories)
                .sum();
    }

    @Override
    public void addAnimal(Animal animal) {
        if(animals.size() == capacity){
            throw new IllegalStateException(NOT_ENOUGH_CAPACITY);
        }
    }

    @Override
    public void removeAnimal(Animal animal) {
        animals.remove(animal);
    }

    @Override
    public void addFood(Food food) {
        foods.add(food);
    }



    @Override
    public String getName() {
        return name;
    }

    @Override
    public void feed() {
        animals.forEach(Animal::eat);
    }


    //"{areaName} ({areaType}):
    //Animals: {animalName1} {animalName2} {animalName3} (…) / Animals: none
    //Foods: {foodsCount}
    //Calories: {sumCalories}"

    @Override
    public String getInfo() {
        String animalReport = getAnimals().isEmpty()
                ?"none"
                :animals.stream()
                .map(Animal::getName)
                .collect(Collectors.joining(" "));

       return String.format("%s (%s):%n + " +
                "Animals: %s%n" +
                "Foods: %d%n +" +
                "Calories: %d",
                name, getClass().getSimpleName(),
               animalReport,foods.size(), sumCalories());
    }

    public void setName(String name) {

        if(name == null && name.trim().isEmpty()){
            throw new NullPointerException(AREA_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public Collection<Food> getFoods() {
        return foods;
    }

    public void setFoods(Collection<Food> foods) {
        this.foods = foods;
    }

    @Override
    public Collection<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(Collection<Animal> animals) {
        this.animals = animals;
    }
}
