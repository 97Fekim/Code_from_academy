package LamdaAndStream;

import java.util.*;

public class LambdaTest2 {
    public static void main(String[] args) {
        List<Tire> list = new ArrayList<>();
        list.add(new Tire(351,"홍길동7", 450));
        list.add(new Tire(4123,"홍길동2", 4500));
        list.add(new Tire(326100,"홍길동9", 45000));
        list.add(new Tire(300,"홍길동4", 450000));

        Collections.sort(list, (o1,o2) ->
                (o1.getPrice() - o2.getPrice()));

        System.out.println(list);
    }
}
