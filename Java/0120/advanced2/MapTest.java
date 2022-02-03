package advanced2;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapTest {
    public static void main(String[] args) {

        // 예제1
        /*Map<String, Car> map1 = new HashMap<String, Car>();
        Car car1 = new Car();
        car1.setDriver("car1 운전자");
        car1.setName("car1");
        car1.setPrice(5000);
        car1.setTotal(50);
        Car car2 = new Car();
        car2.setDriver("car2 운전자");
        car2.setName("car2");
        car2.setPrice(10000);
        car2.setTotal(100);
        // Car 객체 2개의 멤버변수(데이터)를 채워서 아래에서 출력하세요

        // map에 푸쉬
        map1.put("그린", car1);
        map1.put("레드", car2);

        // 키셋 생성
        Set<String> carKeySet = map1.keySet();

        for(String str: carKeySet){ // 문자열의 집합이므로 그 것을 하나씩 꺼내어 문자열 key를 이용하여
            Car temp = new Car();   // key값에 해당하는 데이터(value/ car)를 반환함.
            temp = map1.get(str);
            System.out.printf("Driver : %s\nCar name : %s\nCar price : %d\nCar total : %d\n\n",
                    temp.getDriver(), temp.getName(), temp.getPrice(), temp.getTotal());
        }*/

        // 예제2
        Map<String, Car> map2 = new HashMap<>();

        Car car1 = new Car(10000,100,"car1","driver1",new Tire(500,"aaa",5000));
        Car car2 = new Car(9000,90,"car2","driver2",new Tire(400,"bbb",4000));
        Car car3 = new Car(8000,80,"car3","driver3",new Tire(300,"ccc",3000));
        Car car4 = new Car(7000,70,"car4","driver4",new Tire(200,"ddd",2000));

        map2.put("1", car1);map2.put("2", car2);
        map2.put("3", car3);map2.put("4", car4);

        Set<String> car2KeySet = map2.keySet();

        for(String str: car2KeySet){
            Car temp = map2.get(str);
            System.out.printf("------%s------", temp.getName());
            System.out.println(
                    "\nDriver name = "+temp.getDriver()+
                    "\nCar name = "+temp.getName()+
                    "\nCar price = "+temp.getPrice()+
                    "\nCar total = "+temp.getTotal()+
                    "\nTire Manufacturer = "+temp.getTire().getManufacturer()+
                    "\nTire price = "+temp.getTire().getPrice()+
                    "\nTire weight = "+temp.getTire().getWeight());
                    }
    }
}
