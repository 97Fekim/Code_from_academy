package LamdaAndStream;

import java.awt.*;

public class Lambda {
    public static void main(String[] args) {
        MySum func = (a,b) -> a+b;
        System.out.println(func.sum(10,11));

        MyMinus f1 = (a,b) -> a-b;
        System.out.println(f1.minus(10,11));

        // 함수형 인터페이스 오버라이딩
        MyMinus mymi = new MyMinus() {
            @Override
            public int minus(int a, int b) {
                return a*b;
            }
        };
        System.out.println(mymi.minus(4,5));

        TripleMul tPm = new TripleMul() {
            @Override
            public int tpm(int a, int b, int c){
                return a*b*c;
            }
        };
        System.out.println(tPm.tpm(3,4,8));


    }
}
