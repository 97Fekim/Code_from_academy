package funtionalInterface;

public class ATest {
    public static void main(String[] args) {

        // 이름이 없는 클래스를 생성하여 a에 저장함
        // anonymous 클래스 (익명 클래스)
        A a = new A() {
            @Override
            public void drive() {
                System.out.println("이름이 없는 클래스가 운전중");
            }
        };

        a.drive();
        A b = new B();
        b.drive();


    }
}
