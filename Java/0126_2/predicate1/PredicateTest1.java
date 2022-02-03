package predicate1;

import funtionalInterface.A;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateTest1 {
    public static void main(String[] args) {
        Predicate<Integer> p1,p2,p3,p4;
        p1 = x -> x > 7;
        p2 = x -> x == 3;
        p3 = x -> x%2 == 0;
        p4 = x -> x%5 == 0;

        System.out.println(p1.test(5));
        System.out.println(p2.test(7));

        int[] arr = {1,2,3,4,5,6,7,8,9};
        int[] arr1 = new int[50];

        for(int i=0; i<arr1.length; i++){
            arr1[i] = (int)(Math.random() * 100);
        }

        List<Integer> odd = new ArrayList<>();

        for(int i :arr){
            if(p3.test(i))
                odd.add(i);
        }
        System.out.println(odd);

        List<Integer> fifth = new ArrayList<>();

        for(int i: arr1){
            if(p4.test(i))
                fifth.add(i);
        }
        System.out.println(fifth);
    }

}
