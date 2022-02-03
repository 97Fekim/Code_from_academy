package funtionalInterface;

public class B implements A{

    @Override
    public void drive() {
        System.out.println("A 인터페이스를 구현한 클래스가 운전중 ");
    }
}
