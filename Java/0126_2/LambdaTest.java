

public class LambdaTest {

    public static void main(String[] args) {

        // 람다 예제 1 (String processor)
        /*StringProcessor lambdaSP = x -> "" + x + x;
        StringProcessor lambdaSP1 = x -> {
            String gugu = "";
            for(int i=1; i<10; ++i){
                gugu += x + "x" + i + "=" + x*i + "\n";
            }
            return gugu;
        };
        System.out.println(lambdaSP1.process(7));*/

        // 람다 예제 2 (Pow processor)
        PowProcessor powProcessor = (x,y) -> {

            int index = x;

            for(int  j=1; j <= y; ++j){
                x *= index;
            }

            Integer temp = x;
            return temp.toString();
        };

        System.out.println(powProcessor.process(5,3));

    }

}
