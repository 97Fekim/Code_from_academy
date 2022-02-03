package functionalInterface2;

@FunctionalInterface
public interface TwoArgsProcessor<X> {  // generic : X에 들어오는 데이터 타입에 따라 아래 X가 바뀐다.

    X process(X arg1, X arg2);

}
