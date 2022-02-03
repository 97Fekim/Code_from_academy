package Interface_excercise;

public class SummableTest {

    public static void main(String[] args) {

        Summable summable = new Summable() {
            @Override
            public int sum(int a, int b) {
                drive();
                return a + b;
            }
        };

        System.out.println(summable.sum(7,8));

        SummableC summableC = new SummableC();

        System.out.println(summableC.sum(7,8));

    }
}
