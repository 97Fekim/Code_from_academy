package advanced;

import java.util.Arrays;
import java.util.List;

public class Dish {
    private final String name;
    private final boolean vegetarian;   // 채식주의자 이냐
    private final int calories;
    private final Type type;

    public Dish(String name, boolean vegetarian, int calories, Type type){
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public int getCalories() {
        return calories;
    }

    public Type getType() {
        return type;
    }

    public enum Type {MEAT, FISH, OTHER}

    public String toString() {
        return this.name;
    }

    public static final List<Dish> menu =
            Arrays.asList(
                    new Dish("pork",false,800,Dish.Type.MEAT),
                    new Dish("beef",false,700,Dish.Type.MEAT),
                    new Dish("chicken",false,400,Dish.Type.MEAT),
                    new Dish("french fries",true,300,Dish.Type.MEAT),
                    new Dish("rice",true,350,Dish.Type.OTHER),
                    new Dish("season fruit",true,120,Dish.Type.OTHER),
                    new Dish("pizza",true,550,Dish.Type.OTHER),
                    new Dish("prawns",false,400,Dish.Type.MEAT),
                    new Dish("salmon",false,450,Dish.Type.FISH)
            );
}
