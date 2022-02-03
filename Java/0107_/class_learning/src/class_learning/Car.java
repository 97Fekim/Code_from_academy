package class_learning;

public class Car 
{
	/* 멤버변수 */
	public int doorNumber;
	public int windowNumber;
	public String name;
	public String color;
	
	/* 기본생성자 */
	public Car()
	{
		System.out.println("기본생성자 호출");
	}
	/* 대입생성자 */
	public Car(int n1, int n2, String str1, String str2)
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
	public void setDoorNumber(int doorNumber) 
	{
		this.doorNumber = doorNumber;
	}
	public void setWindowNumber(int windowNumber) 
	{
		this.windowNumber = windowNumber;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public void setColor(String color) 
	{
		this.color = color;
	}
}
