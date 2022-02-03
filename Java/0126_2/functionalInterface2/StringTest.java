package functionalInterface2;

import java.util.Locale;

public class StringTest {

    public static void main(String[] args) {

        StringProcessor toLowerCase = new StringProcessor() {
            @Override
            public String process(String s) {
                return s.toLowerCase();
            }
        };

        StringProcessor toUpperCase = new StringProcessor() {
            @Override
            public String process(String s) {
                return s.toUpperCase();
            }
        };

        System.out.println(toLowerCase.process("FUNCTIONALINTERFACE"));
        System.out.println(toUpperCase.process("functionalinterface"));
    }
}
