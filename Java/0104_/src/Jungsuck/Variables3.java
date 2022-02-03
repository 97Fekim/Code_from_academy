package Jungsuck;

public class Variables3
{
	public static void main(String[] args) 
	{
		String str = 1 + "홍길동" + 1;
		System.out.println(str);
		
		Class_Truck truck1 = new Class_Truck(1,"Giant",2,3);
		
		int a = 8;
		if(a==9)
		{
			System.out.println("a는 9입니다");
		}
		else
		{
			System.out.println("a는 9가 아닙니다");
		}	
	}
}