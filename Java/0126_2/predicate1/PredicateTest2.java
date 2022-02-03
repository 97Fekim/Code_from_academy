package predicate1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateTest2 {
    public static int tt(Predicate<Integer> p, Integer arg){
         if(p.test(arg)){
            return arg * 5;
        }
         else
         {
             return arg * 3;
         }
    }

    public static void main(String[] args) {
        int[] arr1 = new int[50];

        for(int i=0; i < arr1.length; i++){
            arr1[i] = (int)(Math.random() * 100);
        }

        List<Integer> odd = new ArrayList<>();

        for(int j=0; j < arr1.length; j++){
            odd.add(tt(i -> i%5==0, arr1[j]));
        }
        System.out.println(odd);

        odd.clear();
        for(int j=0; j < arr1.length; j++){
            odd.add(tt(i -> i%3==0, arr1[j]));
        }
        System.out.println(odd);

    }
}
