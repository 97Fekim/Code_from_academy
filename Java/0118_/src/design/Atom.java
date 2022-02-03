package design;

public class Atom extends Robot{

    public Atom(String name) {
        super(name);
    }

    @Override
    public void attack() {
        System.out.println("나는 강력한 펀치가 있고 그것으로 공격할 수 있어요");
    }

    @Override
    public void move() {
        System.out.println("나는 날수 있어요!");
    }
}
