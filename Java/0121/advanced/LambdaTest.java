package advanced;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaTest {
    /*public static MyFunction bMethod() {
        MyFunction g = () -> System.out.println("난 bMethod 함수에서 반환된 g 함수에요.");
        return g;
    }*/

    /*public static void aMethod(MyFunction f) {
        f.myMethod();
    }*/

    public static void main(String[] args) {

        // 람다 예제1
        /*MyFunction f = ()->System.out.println("나는 MyFunction f 함수에요");
        MyFunction g = ()->System.out.println("나는 MyFunction g 함수에요");
        MyFunction k = ()->System.out.println("나는 MyFunction k 함수에요");
        MyFunction r = ()->System.out.println("나는 MyFunction r 함수에요");

        aMethod(f);
        aMethod(g);
        aMethod(k);
        aMethod(r);

        MyFunction u = bMethod();
        u.myMethod();*/


        // 람다 예제2
        MyFunction f = (int i) -> {if(i % 2 == 0) return i; else return 0;};

        List<Integer> list1 = new ArrayList<>();

        list1.add(10);list1.add(7);
        list1.add(16);list1.add(67);
        list1.add(52);list1.add(71);

        // list1 출력
        list1.forEach(i->System.out.println(i + ","));

        // list1에서 짝수인 자료 list2에 삽입
        List<Integer>list2 = list1.stream().
                filter(i-> i%2==0).
                collect(Collectors.toList()
        );
        // list2 출력
        System.out.println('\n');
        list2.forEach(i->System.out.println(i + ","));

        //list1에서 *3, +1 연산 후 홀수인 자료를 list3에 삽입
        List<Integer> list3 = list1.stream()
                .filter(i -> i%2 == 0)  // 짝수만 걸러내기
                .map(i -> i * 3 + 1)    // 걸러낸 데이터에 3배하고 1더하기
                .filter(i -> i %2 == 0) // 홀수만 걸러내기
                .collect(Collectors.toList());

        // list3 출력
        System.out.println('\n');
        list3.forEach(i->System.out.println(i + ","));

    }
}

/* Note */
// 자바는 객체지향 언어로 태어났는데 갑자기 함수형 언어의 특징을 도입함
// 함수형 언어(하스겔) : Javascript, 파이썬, 코틀린
// 함수형 일급 객체(시민) => function이 first citizen
// first citizen