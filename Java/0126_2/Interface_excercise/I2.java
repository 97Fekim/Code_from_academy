package Interface_excercise;

public interface I2 {
    String s = "I2";

    static void method1(){
        System.out.println(s);
    }

    default String method2(String x) {
        return x;
    }
}
