public class Test1 
{
	// 문제3) 함수 정의하세요 숫자 2.37f을 반환함 
	// main함수에서 위에서 정의한 함수 호출 후 main함수에서 출력하세요
	public static float func_1()
	{
		return 2.37f;
	}
		
	// 문제4) 함수 정의, 숫자(정수형 파라미터) 한개를 받아서 3을 더한 결과를 반환하는 함수
	public static int func_2(int n)
	{
		return n+3;
	}
	
	// 문제 7) 함수 정의
	// 문자열 파라미터 하나를 받아서 문자열의 길이가 짝수이면 그 문자열 길이의 3배를 반환하고
	// 그렇지 않으면 2배를 한 결과를 반환함
	public static int func_3(String str)
	{
		int len = str.length();
		
		if(len % 2 == 0)
			return 3 * len;
		else
			return 2 * len;
	}
	
	public static int func_4(int[] u)
	{
		int sum = 0;
		for(int i =0; i < u.length; i++)
			sum += i * 10;
		for(int i = 0; i < u.length; i++)
		{
			u[i] = i * (int)(Math.random()*7);
		}
		return sum;
	}
	
	
	public static void main(String[] args) 
	{
		int[] nArray = new int[10];
		for(int i = 0; i < nArray.length; ++i)
		{
			nArray[i] = (int)(Math.random()*20);
		}
		
		for(int i: nArray)
			System.out.println("원래 배열 : " + i + "\t");
		
		int result = func_4(nArray);
		System.out.println(result);
		System.out.println("===배열 전달후 함수 호출 결과===");
		for(int i:nArray)
			System.out.println("이후 배열 : " + i + "\t");
		
	}

}
