package predicate1;

import java.util.function.Predicate;

public class PredicateHelper {
    public static <X> void result(Predicate<X> p, X arg){
        if(p.test(arg))
            System.out.println("이 Predicate는 " + arg + "에 대해서는 true에요");
        else
            System.out.println("이 Predicate는 " + arg + "에 대해서는 false에요");
    }
}
