package zoo.entities.animals;

import static zoo.common.ExceptionMessages.*;

public abstract class BaseAnimal implements Animal {

    private String name;
    private String kind;
    private double kg;
    private double price;

    protected BaseAnimal(String name, String kind, double kg, double price) {
        setName(name);
        setKind(kind);
        setKg(kg);
        setPrice(price);
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {

        if(name == null && name.trim().isEmpty()){
            throw new NullPointerException(ANIMAL_NAME_NULL_OR_EMPTY);
        }

        this.name = name;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {

        if(kind == null && kind.trim().isEmpty()){
            throw new NullPointerException(ANIMAL_KIND_NULL_OR_EMPTY);
        }

        this.kind = kind;
    }

    @Override
    public double getKg() {
        return kg;
    }

    public void setKg(double kg) {
        this.kg = kg;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {

        if(price <= 0){
            throw new IllegalArgumentException(ANIMAL_PRICE_BELOW_OR_EQUAL_ZERO);
        }

        this.price = price;
    }
}
