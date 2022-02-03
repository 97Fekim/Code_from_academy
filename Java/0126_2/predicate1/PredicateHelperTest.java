package predicate1;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import static predicate1.PredicateHelper.result;

public class PredicateHelperTest {

    public static void main(String[] args) {
        Predicate<Integer> p1 = x-> x>2;
        Predicate<String> p2 = s-> s.charAt(0) == 'H';
        BiPredicate<String,Integer> p3 = (s,i) -> s.charAt(i) == 'H';

        result(p1,6);
        result(p2, "Heineken");
        result(p2, "Heineken");

        }

}