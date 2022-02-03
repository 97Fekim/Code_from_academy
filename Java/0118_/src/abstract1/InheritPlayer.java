package abstract1;

public class InheritPlayer extends Player {
    @Override
    void stop(){
        System.out.println("추상 클래스 Player를 상속 받은 stop 추상메소드를 오버라이딩 한 메소드");
    }

}
