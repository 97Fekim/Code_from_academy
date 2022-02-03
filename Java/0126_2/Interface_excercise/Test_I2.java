package Interface_excercise;

public class Test_I2 {
    public static void main(String[] args) {
        
        // static 메서드이므로 객체 생성 없이 바로 호출 가능
        I2.method1();

        // 호출되면 멤버변수 s의 I2 값 출력됨
        I2 objc2 = new C2();

        // 재정의 했으므로 재정의한 메서드 호출됨
        I2 objc3 = new C3();

        // 부모(I2 인터페이스의) default 메서드 호출됨. method2(String x){return s+x;}
        System.out.println(objc2.method2("Hello"));
        System.out.println(objc3.method2("World"));


    }
}
