package Interface_excercise;

public class Test_I4 {
    public static void main(String[] args) {
        System.out.println(I4.getName("Smith", "female"));
        System.out.println(I4.getName("Jones", "male"));

        int a = 8;
        int b = 9;
        String result = a>b ? "a" : "b" ;
        System.out.println(result);

    }
}
