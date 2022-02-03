package funtionalInterface;

@FunctionalInterface
public interface StringProcessor {
    String process(String x);  // 추상메서드
}
// 하나의 추상메서드만 있어야 functional interface이다.


