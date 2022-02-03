package advanced2;

public class Apple {
    private int weight = 0;
    private String color = "";

    public Apple(int weight, String color) {
        this.weight = weight;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "weight=" + weight +
                ", color='" + color + '\'' +
                '}';
    }

    Integer getWeight() {
        return this.weight;
    }

    String getColor(){
        return this.color;
    }

    void setWeight(int weight) {
        this.weight = weight;
    }

    void setColor(String color){
        this.color = color;
    }

    public boolean isGreenApple(Apple apple){
        return "green".equals(apple.getColor());
    }


}
