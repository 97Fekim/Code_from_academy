package class_learning;

public class Car2 
{
	/* 멤버변수 */
	public int doorNumber;
	public int windowNumber;
	public String name;
	public String color;
	
	/* 기본생성자 */
	public Car2()
	{
		System.out.println("기본생성자 호출");
	}
	/* 대입생성자 */
	public Car2(int n1, int n2, String str1, String str2)
	{
		this.doorNumber = n1; this.windowNumber = n2; this.name = str1; this.color = str2;
		System.out.println("파라미터 4개를 가진 생성자 호출");
	}
	
	/* getter */
	public int getDoorNumber()
	{
		return this.doorNumber;
	}
	public int getWindowNumber()
	{
		return this.windowNumber;
	}
	public String getName()
	{
		return this.name;
	}
	public String getColor()
	{
		return this.color;
	}
	
	/* setter */
	public Car2 setDoorNumber(int doorNumber) 
	{
		this.doorNumber = doorNumber;
		return this;
	}
	public Car2 setWindowNumber(int windowNumber) 
	{
		this.windowNumber = windowNumber;
		return this;
	}
	public Car2 setName(String name) 
	{
		this.name = name;
		return this;
	}
	public Car2 setColor(String color) 
	{
		this.color = color;
		return this;
	}
}
