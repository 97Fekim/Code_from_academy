package temp;

import java.util.function.BiPredicate;

public class CarTest {
    public static boolean compare(BiPredicate<String, String> p, String a, String b){
        return true;
    }

    public static void main(String[] args) {
        String[] name = {"a","b","c","d","e","f","g","h","t","h","p"};
        String[] driver = {"A","B","C","D","E","F","G","H"};
        String[] nameResult = new String[name.length];
        String[] dirverResult = new String[driver.length];
        Car[] cars = new Car[50];

        for(int i=0; i<cars.length; ++i){
            Car a = new Car();
            a.setDriver(driver[(int)(Math.random()*driver.length)]);
            a.setName(name[(int)(Math.random()*name.length)]);
            a.setPrice((i+1)*100);
            a.setTire((i+5)*50);
            cars[i]=a;
        }
        for(Car i : cars)
            System.out.println(i);

        for(int j=0; j<10; ++j){
            nameResult[j] = name[(int)(Math.random()*name.length)];
        }
        // 문제1) 람다를 만들고name과 driver가 랜덤의 인덱스에서 같을 경우 true를 반환하고 true의 갯수를 헤아리세요


        int sameCnt = 0;
        BiPredicate<String, String> li = (i,j) -> i.equals(j);
        for(int i=0; i<100; i++){
            if(compare(li, cars[(int)(Math.random()*cars.length)].getName(),
                    cars[(int)(Math.random()*cars.length)].getDriver()))
                sameCnt++;
        }
        System.out.println(sameCnt);
    }
}
