package function2;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionTest {
    public static void main(String[] args) {

        BiFunction<Integer, Character, String> bi = (x,z) -> {
            if(Character.isUpperCase(z))
                return (x%2)==0 ? "EVEN":"ODD";
            return (x%2==0) ? "even":"odd";
        };

        Function<String, Double> bi2 = x ->
                x.equalsIgnoreCase("even")? 3.0:4.0;

        Double d = bi.andThen(bi2)
                .apply(4, 'U');

        System.out.println(d);
        System.out.println(bi.apply(5,'x'));


    }
}
