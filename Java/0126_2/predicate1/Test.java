package predicate1;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class Test {
    public static int tt(BiPredicate<Integer, Integer> p, int a, int b){
        if(p.test(a,b))
            return 2;
        else
            return 1;
    }

    /*public static void main(String[] args) {
        System.out.println(tt( (x,y) -> x+y < 15, (x,y)          ));
    }*/
}