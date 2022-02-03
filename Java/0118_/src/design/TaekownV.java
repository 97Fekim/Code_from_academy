package design;

public class TaekownV extends Robot{

    public TaekownV(String name){
        super(name);
    }

    @Override
    public void attack() {
        System.out.println(("나는 미사일을 가지고 있고 그것으로 공격할 수 있어요"));
    }

    @Override
    public void move() {
        System.out.println("나는 도보로 이동합니다");
    }
}
