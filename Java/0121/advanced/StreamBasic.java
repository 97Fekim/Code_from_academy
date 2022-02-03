package advanced;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class StreamBasic {
    public static void main(String[] args) {
        // 자바 7
        //getLowCaloricDishesNamesInJava7(Dish.menu).forEach(System.out.println());

        // 자바 8
        getLowCaloricDishesNamesInJava8(Dish.menu).forEach((i)->System.out.println());
    }

    private static List<String> getLowCaloricDishesNamesInJava7(List<Dish> dishes) {

        /* 저칼로리 접시들이 담길 리스트를 하나 생성한다 */
        List<Dish> lowCaloricDishes = new ArrayList<>();

        /* 디쉬 리스트를 받아서, 칼로리가 400 이하인 애들을 새로운 접시에 담는다 */
        for(Dish d: dishes){
            if(d.getCalories()<400){
                lowCaloricDishes.add(d);
            }
        }

        /* 새로운 접시의 이름들을 저장할 리스트를 생성한다 */
        List<String> lowCaloricDishedName = new ArrayList<>();

        /* 새로운 접시를 칼로리를 기준으로 정렬한다. */
        Collections.sort(lowCaloricDishes, new Comparator<Dish>(){
            @Override
            public int compare(Dish d1, Dish d2){
                return Integer.compare(d1.getCalories(), d2.getCalories());
            }
        });

        /* 저칼로리 접시들의 이름들이 저장될 리스트에, 저칼로리 접시들에서 이름을 꺼내와 담는다. */
        for(Dish d : lowCaloricDishes){
            lowCaloricDishedName.add(d.getName());
        }

        /* 저칼로리 접시들의 이름이 담긴 리스트를 반환한다. */
        return lowCaloricDishedName;
    }

    private static List<String> getLowCaloricDishesNamesInJava8(List<Dish> dishes) {
        return dishes.stream()
                .filter(d->d.getCalories()<400)         // 400이하인 애들을 골라서,
                .sorted(comparing(Dish::getCalories))   // 칼로리를 기준으로 정렬하고
                .map(Dish::getName)         // 이름을 기준으로 모두다
                .collect(toList());         // 모아서 list에 삽입한다. 그리고 그 리스트를 반환한다.
    }

}
