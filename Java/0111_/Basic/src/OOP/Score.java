package OOP;

public class Score
{
	private int math;	// 멤버변수(Score 클래스의 멤버)
	private int eng;	// 
	private int korea;
	
	// 이 클래스의 멤버변수는 private이라서 이 클래스를 벗어난곳에서 접근불가능
	// 이 클래스를 객체로 만들어서 사용하고자 하는 클래스에서 사용하려면??
	
	// setter(사용하고자 하는 클래스에서 사용하고자 하는 클래스의 객체의 멤버변수의 값을 저장하는 함수)
	// set = write = store
	// setter를 만드는 방법
	// 멤버변수의 첫 글자를 대문자로 하고, get을 붙인다.
	// 이 setter(함수)의 파라미터의 값을 받아서 멤버변수의 값을 저장.
	// 반환값이 없다. (void)

	// getter(클래스에서 객체의 멤버변수의 값을 읽어올때 사용하는 함수)
	// get = read
	// getter 만드는 방법
	// 멤버변수의 첫글자를 대문자로 하고 get을 붙인다.
	// 이 getter(함수)는 파라미터가 없고, 반환값은 멤버변수이다.
	
	int getMath()
	{
		return this.math;
	}
	
	int getEng()
	{
		return this.eng;
	}
	
	int getKorea()
	{
		return this.korea;
	}
	
	void setMath(int math)
	{
		this.math = math;
	}
		
	void setEng(int eng)
	{
		this.eng = eng;
	}
	
	void setKorea(int korea)
	{
		this.korea = korea;
	}
	
	
	/* 클래스 내에 있는 함수(메소드) */
	public int g()
	{
		return 7;
	}
	
	
	
}
