package temp;

public class Class_temp 
{
	public static boolean f(int a)
	{
		if(a%2 == 0)
			return true;
		else
			return false;
	}
	
	public static void main(String[] args) 
	{
		boolean[] arr = new boolean[10];
		int[] arri = new int[10];
		for(int i = 0; i < arri.length; i++)
		{
			arri[i] = (int)(Math.random()*10);
		}

		for(int i = 0; i < 10; ++i)
			arr[i] = f(arri[i]);
		
		for(boolean i: arr)
			System.out.println(i);
		
		
	}
}
