public class FIVoidTest {
    public static void main(String[] args) {
        FIVoid lambdaOddSum = x -> {
            int oddSum = 0;
            for(int i=0; i <= x; i++){
                if(i%2 != 0)
                    oddSum += i;
            }
            System.out.println(oddSum);
        };
        lambdaOddSum.method1(7);

        int[] array = {11,12,13,14,15};
        FIVoid lambdaSubsript = x -> {
            try{                                // try문 무조건 실행하고 예외(Exception)이 발생하면 catch문으로 진입
                int value = array[x];           // 배열의 index가 없는데 접근하려고 하면 예외 발생됨
                System.out.println(value);
            }catch ( Exception e){
                System.out.println("Index " + x + " is out of bounds");
            }                                   // file이나 database 접근시 많이 사용한다.
        };
        lambdaSubsript.method1(4);
    }
}
