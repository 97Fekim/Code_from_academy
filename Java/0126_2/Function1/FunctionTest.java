package Function1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FunctionTest {
    public static void main(String[] args) {

        int[] tire = {20,30,40,50,60,70,80,90,100,15};
        String[] address = {"부산","마산","울산","대수","포항","미금","서울","영등포","제주도","울릉도"};
        int[] price = {11,33,5,6,17,18,11,34,56,88};
        String[] name = {"홍길동","홍말자","이재오","김개똥",
                "김말자","미금남자","여수남자","제주사람","강남호","이휘재"};
        
        List<String> strPrice = new ArrayList<>();

        for(int j=0; j < price.length; j++){
            strPrice.add("" + price[j]);
        }
        
        // Function<paremeter, return_value>, 즉 파라미터와 리턴 형식을 제네릭으로 받는다.
        Function<String, Integer> f;
        f = x -> Integer.parseInt(x);
        int i = f.apply("100");

        //System.out.println(i);
        
        List<String> str = Arrays.asList("100", "200", "300", "400", "55", "77");
        List<Integer> iList = str.stream().map(temp->Integer.parseInt(temp)).collect(Collectors.toList());
        System.out.println(iList);

        // map을 이용하여 적용하고
        // 결과 출력
        // 문제2) strPrice list의 문자열을 정수로 변환 stream, map, lambda 사용

    }
}
