package Function1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ComposeTest {
    public static void main(String[] args) {
        Function<Boolean, Integer> fbi = x -> x==true ? 1:0;
        Function<String, Boolean> fsb = x -> Boolean.parseBoolean(x);

        System.out.println(fbi.compose(fsb).apply("false"));

        List<Integer> al1 = new ArrayList<>();
        for(int i=0; i <10; i++){
            al1.add((i+1)*5);
        }
        List<Integer> al2 = al1.stream()
                .filter(i -> i>10)
                .collect(Collectors.toList());


    }
}
