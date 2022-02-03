package functionalInterface3;

import java.util.ArrayList;
import java.util.List;

public class PetTest {

    private static void matchPet(String criteria, PetMatcher matcher, Pet pet){
        System.out.println("\n" + criteria + ":");
        System.out.println("First : " + matcher.first(pet));
        System.out.println("ALL matches: ");
        List<Pet> matches = matcher.match(pet);
        for(Pet p: matches)
            System.out.println(p);
    }

    public static void main(String[] args) {

        Pet.pets.add(new Pet("Doring", "dog", "poodle", "white" , 900.00));
        Pet.pets.add(new Pet("Diring", "dog", "poodle", "green" , 800.00));
        Pet.pets.add(new Pet("Daring", "dog", "poodle", "yellow" , 700.00));
        Pet.pets.add(new Pet("Dooring", "dog", "poodle", "white" , 750.00));
        Pet.pets.add(new Pet("During", "dog", "poodle", "white" , 850.00));

        PetMatcher breadMatcher = new PetMatcher() {
            @Override
            public List<Pet> match(Pet pet) {   // 사용자가 검색하고자 하는 코드를 만들어 제공함
                List<Pet> matches = new ArrayList<>();
                for(Pet p: Pet.pets)
                    if(p.equals(pet))
                        matches.add(p);
                return matches;
            }
        };

        matchPet("Poodles",breadMatcher, new Pet(null, "dog", "poodle", "null", 0.0));

        PetMatcher priceMatcher = new PetMatcher() {
            @Override
            public List<Pet> match(Pet pet) {
                List<Pet> matches = new ArrayList<>();
                for(Pet p: Pet.pets)
                    if(p.price <= pet.price)    // 상점(Pet 클래스에 저장된 static의 List)
                        matches.add(p);
                return matches;
            }
            public Pet first(Pet pet){
                int index = -1;
                for(Pet p: Pet.pets)
                    if(p.price <= pet.price)
                        return p;
                return null;
            }
        };
        matchPet("Pets for $800 or less", priceMatcher, new Pet(null, null, null, null, 750.0));


        // 문제 : 색상이 일치하는 것을 matches 리스트에 저장하는 코드 작성
        PetMatcher colorMatcher = new PetMatcher() {
            @Override
            public List<Pet> match(Pet pet) {
                List<Pet> matches = new ArrayList<>();
                for(Pet p: Pet.pets)
                    if(p.color.equals(pet.color))    // 상점(Pet 클래스에 저장된 static의 List)
                        matches.add(p);
                return matches;
            }
            public Pet first(Pet pet){
                int index = -1;
                for(Pet p: Pet.pets)
                    if(p.color.equals(pet.color))
                        return p;
                return null;
            }
        };
        matchPet("color matching", colorMatcher, new Pet(null, null, null, "white", 0.0));
        
    }
}
