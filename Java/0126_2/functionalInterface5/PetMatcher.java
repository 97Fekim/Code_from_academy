package functionalInterface5;

import java.util.List;

@FunctionalInterface
public interface PetMatcher {   // 추상메서드, 사용자가 원하는 검색 조건 저장
    List<Pet> match(Pet pet);
    // Pet 타입의 데이터를 여러개(배열/List) 담아서 보낸다
    
    default Pet first(Pet pet){ // default 메서드
        int index = Pet.pets.indexOf(pet);
        return index > -1 ? Pet.pets.get(index): null;
    }

}
