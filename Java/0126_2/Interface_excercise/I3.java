package Interface_excercise;
import java.util.Random;

public interface I3 {

    private int getNumber(){
        return new Random().nextInt(100);
    }

    default String M1(String s) {
        return this.getNumber() + s;
    }

    // 자바 9버전에서 인터페이스가 private 메서드 사용가능
    // private 메서드를 default 메서드를 호출하면 유용하다

}
