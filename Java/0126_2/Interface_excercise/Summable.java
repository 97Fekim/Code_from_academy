package Interface_excercise;

public interface Summable {
    int sum(int a, int b);

    private int green(int a){
        return a * 3;
    }

    default void drive(){   //2가지 버전, 1)이 메서드 재정의 안한 버전, 2)재정의 한 버전을 main함수에서 생성하세요
        System.out.println("Summable 인터페이스에서 운전중입니다. + " + green(4));
    }

}
