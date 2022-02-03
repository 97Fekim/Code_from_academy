package class_ex;

public class Class_ex1
{
	/* 멤버가 무려 3개! */
	int math;
	int korea;
	int eng;
	
	/* static 변수 */
	static int mung = 200;	// 객체를 생성하지 않고 바로 접근 가능하다.
	
	public int avg(float t)
	{
		return (int)(t/3.0f);
	}
}
