package collection1;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        // List<Integer> al = new ArrayList<Integer>();
        List<Integer> al = new ArrayList<>();   // 제네릭을 넣지 않아도 상관없다
        al.add(3);
        al.add(13);
        al.add(23);
        al.add(333);
        al.add(1233);
        System.out.println(al.get(0));  // 읽을때는 get 메소드 호출

        for(int i: al){ // Integer -> int (unboxing)
            System.out.println(i);
        }

        // 문제 2)
        List<String> al2 = new ArrayList<>(10);
        // 여기에 문자열 10개를 추가한 후 출력하세요
        al2.add("a");
        al2.add("b");
        al2.add("c");
        al2.add("d");
        al2.add("e");
        al2.add("f");
        al2.add("g");
        al2.add("h");
        al2.add("i");
        al2.add("j");

        for(String str: al2)
            System.out.println(str);

        List<Float> al3 = new ArrayList<>();
        for(int i= 0; i < 10; ++i){
            al3.add((float)(Math.random()*100));
        }
        for(float f:al3){
            System.out.println(f);
        }

        List<Car> al4 = new ArrayList<>();


        for(int i=0; i < 10; ++i) {
            Car car = new Car();
            car.setPrice((int)(Math.random()*100));
            car.setName("temp");
            car.setPrice((int)(Math.random()*100));
            al4.add(car);
        }
        for(Car car: al4)
        {
            car.setName("temp");
            car.setManufacturer("temp_company");
            car.setPrice(1000);
        }

        for(Car car: al4)
        {
            System.out.println(car.getName());
            System.out.println(car.getManufacturer());
            System.out.println(car.getPrice());
        }

    }
}
