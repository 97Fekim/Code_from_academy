package class_ex;

public class Class_ex2 
{
	/* 스태틱 메소드 */
	public static int sum(int a, int b)
	{
		return a + b;
	}
	
	public static void main(String[] args) 
	{
		Class_ex1 ex1 = new Class_ex1();	// 생성자(클래스 이름과 동일한 함수)
		// Class_ex1 (타입), ex1(참조변수/객체)
		// 클래스 (설계도면)
		// 클래스를 가지고, 제품(실물)을 생성한다 => 객체(Object/인스턴스/instance)
		// 객체상태가 메모리에 올라간 상태이다.
		// 자바 ==> 객체 지향 언어 OOP(Object Oriented Program)
		// 항상 객체를 생성 후 클래스의 멤버에 접근해라.
		// 생성자는 객체 생성시 자동으로 호출됨, new 키워드와 함께 사용함
		
		ex1.math = 70;
		ex1.eng = 30;
		ex1.korea = 100;
				
		int math = ex1.math;	// math는 지역변수(local variable), ex1.math는 멤버변수.
		int eng = ex1.eng;
		int korea = ex1.korea;
		int total = math + eng + korea;
		
		System.out.println(math + " " + eng + " " + korea + " " + total);
		System.out.println(Class_ex1.mung);
		
		System.out.println(ex1.avg(20.9f));
		
	}
}
