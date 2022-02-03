package functionalInterface5;

import java.util.ArrayList;
import java.util.List;

public class Pet {
    String name;
    String color;
    double price;
    static List<Pet> pets = new ArrayList<>();  // main 함수에서 new를 이용하여 데이터를 저장
    // Pet.pets.add(Pet 객체 추가)

    public Pet(){}
    public Pet(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Pet{ " +
                "price = " + price +
                " }";
    }

}
