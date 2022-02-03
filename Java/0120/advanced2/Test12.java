package advanced2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test12 {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        map.put("a",11);
        map.put("c",16);
        map.put("d",13);
        map.put("f",111);

        list.add("a");
        list.add("f");
        list.add("z");
        list.add("l1");

        // 문제) list의 문자열에 해당하는 value만 list에 담기

        /*for(int i=0; i < list.size(); ++i) {
            if (map.containsKey(list.get(i)))
                list2.add(map.get(list.get(i)));
        }*/

        // 위아래 same same

        for(String i : list){
            if(map.containsKey((i))){
                list2.add(map.get(i));
            }
        }

        System.out.println(list2);
    }
}
