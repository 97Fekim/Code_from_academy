package advanced2;

import java.util.ArrayList;
import java.util.List;

public class ListTest {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(5);list1.add(4);list1.add(2);
        list1.add(0);list1.add(1);list1.add(3);

        List<Integer> list2 = new ArrayList<>(list1.subList(1,4));
        list2.add(11);list2.add(17);list2.add(6);

        System.out.println(list1.toString());
        System.out.println(list2.toString());

        // list2에서 list1에 포함한 객체들을 삭제한다.
        for(int i = list2.size()-1; i>=0; i--){ // 삭제는 맨 뒤부터 합니다. 앞에서부터 삭제하면 index가 변경되기 때문에.
            if(list1.contains(list2.get(i)))    // list2 에서 하나씩 꺼내온 데이터가
                // list1에 포함되어 있으면, true를 반환하여 조건문 실행
                list2.remove(i);    // 해당 index의 데이터를 삭제한다.
        }

        System.out.println("=================");
        System.out.println(list1);
//        System.out.println(list2);

        boolean tt = list1.contains(7);

        int[] data = {1,2,3,4,5};
        System.out.println(data);



    }
}
