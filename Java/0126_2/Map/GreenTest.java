package Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GreenTest {
    public static void main(String[] args) {

        int[] tire = {20,30,40,50,60,70,80,90,100,15};
        String[] address = {"부산","마산","울산","대수","포항","미금","서울","영등포","제주도","울릉도"};
        int[] price = {11,33,5,6,17,18,11,34,56,88};
        String[] name = {"홍길동","홍말자","이재오","김개똥",
                "김말자","미금남자","여수남자","제주사람","강남호","이휘재"};

        //Green 객체 데이터 채우기
//        Map<String, Green> map = new HashMap<>();
//        for(int i=0; i < tire.length; ++i) {
//            Green temp = new Green();
//            temp.setTire(tire[i]); temp.setAddress(address[i]);
//            temp.setPrice(price[i]); temp.setName(name[i]);
//            map.put("" + i, temp);
//        }
//
//        for(String i :map.keySet()){
//            System.out.println(map.get(i).toString());
//        }

        Map<String, List<Green>> map2 = new HashMap<>();

        for(Integer j=0; j < 10; ++j) {
            List<Green> list1 = new ArrayList<>();
            for (int i = 0; i < 10; ++i) {
                Green temp = new Green();
                temp.setTire(tire[i]+(int)(Math.random()*100));
                temp.setAddress(address[i]+(int)(Math.random()*100));
                temp.setPrice(price[i]+(int)(Math.random()*100));
                temp.setName(name[i]+(int)(Math.random()*100));
                list1.add(temp);
            }
            map2.put(j.toString(), list1);
        }

        for(String j :map2.keySet()){
            for(int i=0; i<10; ++i){
            System.out.println(map2.get(j).get(i));
            }
            System.out.println();
        }



    }
}
