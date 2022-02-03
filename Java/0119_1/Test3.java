package Advanced;

import java.util.HashSet;
import java.util.Set;

public class Test3 {
    public static void main(String[] args) {

        Set<Integer> a = new HashSet<>();
        a.add(5);
        a.add(5);

        for(int i:a) {
            System.out.println(i);
        }
    }
}
