public class FI2Test {
    public static void main(String[] args) {
        FI2 fi2Lambda1 = (a,b) -> a + Integer.toString(b);
        String res = fi2Lambda1.method1("홍길동",7);

        System.out.println(fi2Lambda1.method1("안녕하세요",1));


    }
}
