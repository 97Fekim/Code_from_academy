package design;

public abstract class Robot {
    private String name;
    public Robot(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    
    /* 추상클래스 */
    public abstract void attack();  // 공격기능
    public abstract void move();    // 이동수단
}
