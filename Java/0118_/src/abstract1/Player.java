package abstract1;

abstract public class Player {
    void play(int pos){
        System.out.println("위치는 " + pos + "입니다.");
    }

    abstract void stop();    // 함수의 기능부가 없이 선언만 한다. (추상메소드)
    // 구현(기능부를 추가), implement

}
