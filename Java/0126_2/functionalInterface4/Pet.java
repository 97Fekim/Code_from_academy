package functionalInterface4;

import java.util.ArrayList;
import java.util.List;

public class Pet {
    String name;
    String animal;
    String bread;
    String color;
    double price;
    static List<Pet> pets = new ArrayList<>();  // main 함수에서 new를 이용하여 데이터를 저장
    // Pet.pets.add(Pet 객체 추가)

    public Pet(String name, String animal, String bread, String color, double price) {
        this.name = name;
        this.animal = animal;
        this.bread = bread;
        this.color = color;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                ", animal='" + animal + '\'' +
                ", bread='" + bread + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object obj){
        Pet p = (Pet)obj;
        return animal.equals(p.animal) && bread.equals(p.bread);

    }

}
