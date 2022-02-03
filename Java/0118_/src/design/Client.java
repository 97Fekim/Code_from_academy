package design;

public class Client {
    public static void main(String[] args) {
        // Robot으로 참조변수 (taekwonV)를 만들어 TaekwonV 객체를 생성하여
        // 부모의 참조변수인 taekwonV에 자식 객체를 저장함
        // 생성자의 매개변수로 "태권브이" 전달함
        
        // Robot으로 참조변수(atom)을 만들어 Atom 객체를 생성하여
        // 부모의 참조변수인 atom에 자식 객체를 저장함
        // 생성자의 매개변수로 "아톰" 전달함
        
        // 화면에 출력함
        // "내이름은 + taekwonV.getName() + 입니다"
        // taekwonV의 move() 메소드 호출
        
        Robot tk = new TaekownV("태권브이");
        Robot at = new Atom("아톰");


    }
}
