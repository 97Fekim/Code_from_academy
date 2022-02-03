import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class basic {
    public static void main(String[] args) {

        // Colelction => List, Set, Map<key,value>
        // String, 람다, map
        Map<Integer, String> map = new HashMap<>();

        map.put(100, "Amit");
        map.put(101, "Vinay");
        map.put(102, "Rahul");

        Set<Map.Entry<Integer, String>> t = map.entrySet(); // 전체 데이터를 반환

        for(Entry<Integer, String> i : t){
            String str = "키 : " + i.getKey() + ", Vaule : " + i.getValue();
            System.out.println(str);
        }

        Set<Integer> s = map.keySet();   // key값을 set(집합)으로 반환함.
        for(int i: s){
            String str1 = map.get(i);
            System.out.println(str1);
        }

        // List
        // 1)추가 => add
        // 2)읽어올때 => get(index)

        // Map
        // 1)추가=> put (key, value)
        // 2)읽어올때 => get(key) => value
        // 3)key를 찾고자 하면, keySet을 호출하면 key들을 set으로 준다.

    }
}
