package Example;

public class Operator1
{
	public static void main(String[] args) 
	{
		int[] arr = {2,3,4,5,6,12,17,21};
		for(int i:arr)
			System.out.println(i);
		
		// arr배열의 값이 짝수인것 들만의 합과 개수를 구하세요
		int sum = 0;
		int len = arr.length;
		for(int i = 0; i < len; ++i)
			if(arr[i] % 2 == 0)
				sum = sum + arr[i];
		System.out.println("sum : "+sum);
		
	}
}