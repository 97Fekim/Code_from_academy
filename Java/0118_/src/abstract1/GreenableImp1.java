package abstract1;

public class GreenableImp1 implements Greenable {

    @Override
    public void run() {
        System.out.println("달린다");   
    }

    @Override
    public void walk() {
        System.out.println("걷는다");
    }

    @Override
    public void sleep() {
        System.out.println("잔다");
    }
}
