package funtionalInterface;

import java.util.Locale;

public class StringTest {
    public static void main(String[] args) {

        // 익명클래스 (이름없는 클래스)
        StringProcessor anonSP = new StringProcessor() {

            @Override
            public String process(String x) {
                return x.toUpperCase(); // 대문자로 바꿔버리기
            }
        };

        NamedStringProcessor namedSP = new NamedStringProcessor();
        System.out.println(namedSP.process("hello"));
        System.out.println(anonSP.process("hello"));


    }
}
