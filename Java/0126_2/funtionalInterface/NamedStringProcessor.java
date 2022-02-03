package funtionalInterface;

public class NamedStringProcessor implements StringProcessor{

    @Override
    public String process(String x) {
        return x.toUpperCase();
    }

}
