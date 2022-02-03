package advanced2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FilteringApples {
    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(
                new Apple(90,"green"),
                new Apple(170,"green"),
                new Apple(130,"red"),
                new Apple(250,"blue"),
                new Apple(189,"green"),
                new Apple(346,"red")
                );

        List<Apple> greenApples = filterApples(inventory, FilteringApples::isGreenApple);
        System.out.println(greenApples);
        List<Apple> heavyApples = filterApples(inventory, (a) -> a.getWeight()<200);    // 무게가 200g 이하인 데이터만 담아라;
        System.out.println(heavyApples);

        /* 무게를 기준으로 인벤토리 정렬 */
        inventory.sort((o1,o2)->o1.getWeight().compareTo(o2.getWeight()));
        System.out.println(inventory);
    }
    
    private static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p){
        // 문제5) 코드 채우세요
        // advanced for 문을 이용하여 inventory에서 하나씩 꺼내어

        /* 람다식 이용*/
        List<Apple> result = inventory
                .stream()
                .filter(ap-> p.test(ap) == true)
                .collect(Collectors.toList());

        /* 객체지향 이용 */
//        for(Apple ap : inventory){
//            if(p.test(ap) == true)
//                result.add(ap);
//        }

        // 꺼낸 데이터는 Apple 타입이고 이 메서드의 두번째 파라미터인 p는 함수형 인터페이스 중 하나인 Predicate 타입인데
        // 추상 메서드 하나를 가지고 있고 그 메서드명은 test 이므로 test를 진행하고 꺼낸 데이터를 조건문에 하나 넣어 그 test를 통과하여
        // true값을 가진 데이터만 result에 추가하세요
        
        // 함수형 인터페이스 (Supplier (get), Consumer(accept), Function(apply), Predicate(test))
        // filter의 파라미터로는 true, false를 반환하는 Prediate 타입을 매개변수로 전달함
        // stream으로 변환하여 중간(intermediate) 메서드는 chain으로 연결 가능하고, 종단(terminal)메서드는
        // 마지막에만 사용 가능함, forEach, collect, reduce는 terminal 메서드임

        return result;
    }
    
    public static boolean isGreenApple(Apple apple){
        return "green".equals(apple.getColor());
    }

    public static boolean isHeavyApple(Apple apple){
        return apple.getWeight() >= 150;
    }

}
