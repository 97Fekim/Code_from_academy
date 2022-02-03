package advanced;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class RedTest {

    public static void main(String[] args) {
        List<Red> list1 = new ArrayList<>();
        for(int i=0; i<100; i++){
            list1.add(new Red(
                    (int)(Math.random()*1000),
                    "홍길동"+(int)(Math.random()*100000),
                    (int)(Math.random()*1000),
                    (int)(Math.random()*1000),
                    (int)(Math.random()*1000),
                    (float)(Math.random()*1000),
                    "서울도봉구" + (int)(Math.random()*100)
            ));
        }

        for(Red i: list1){
            System.out.print(
                    "\n{주소 : " + i.getAddress() +
                    ", 이름 : " + i.getName() +
                    ", 영어 : " + i.getEng() +
                    ", 국어 : " + i.getKorea() +
                    ", 총점 : " + i.getTotal() +
                    ", 가격 : " + i.getPrice() +
                    ", 수학 : " + i.getMath() + "}");
        }

        int result = list1.stream()
                .filter(i->i.getName().length()%2==0)
                .map(i->i.getAddress().length())
                .reduce(0,(acc,cur)->acc+cur);

        List<Integer> list7 = new ArrayList<>();

        for(int i=0; i< 20; i++){
            list7.add(i+1);
        }

        list7.stream().reduce(7,(i,j)->{
            i = i+j;
            System.out.println("결과 : " + i + " " + "cur : " + j);
            return i;
        });
        System.out.println(result);

        int sum = 0;
        for(Red i : list1){
            if(i.getMath() >= 100 && i.getTotal() >= 70){
                sum += i.getMath()*3;
            }
        }

        // Optional은 null일 경우에 대한
        Optional<Integer> sum1 = list1.stream()
                .filter(i->i.getTotal() >= 100 && i.getMath() >= 70)
                .map(i->i.getMath())
                .reduce((i,j)->i+j*3);
        System.out.println(sum1.get());

        List<Red> list8 = new ArrayList<>();
        for(Red i:list1){
            if(i.getTotal() >= 100 && i.getKorea() >= 70){
                if((i.getKorea()*3)%4 == 0){
                    list8.add(i);
                }
            }
        }

        // total이 100보다 크고, korea는 70보다 큰 녀석들 중에서
        // korea 성적에다가 3 곱하고 4로 나눴더니 0인 애들 만...
        // list8에다가 추가한다.

        List<Red> list9 =
                list1.stream()
                .filter(i -> (i.getTotal() >= 100 && i.getKorea() >= 70))
                .filter(i -> (i.getTotal() * 3)%4 == 0)
                .collect(Collectors.toList()
                );

        System.out.println(list9);


    }
}

// 문제3) Red 클래스의 name의 문자열의 길이가 짝수인것들에 해당되는 address 문자열의 총합 구하기
// 문제4) Red 클래스의 총점이 100점 이상인 것중 math가 70점 이상인 것들의 각각에 3배한 결과의 총합 구하기
// 문제5) Red 클래스의 총점이 100점 이상인 것중 korea가 70점 이상인 것들의 각각에 3배한 결과의 값이 4의 배수인 것들만 list2에 담기