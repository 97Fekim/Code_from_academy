public class Test1 
{
	// ����3) �Լ� �����ϼ��� ���� 2.37f�� ��ȯ�� 
	// main�Լ����� ������ ������ �Լ� ȣ�� �� main�Լ����� ����ϼ���
	public static float func_1()
	{
		return 2.37f;
	}
		
	// ����4) �Լ� ����, ����(������ �Ķ����) �Ѱ��� �޾Ƽ� 3�� ���� ����� ��ȯ�ϴ� �Լ�
	public static int func_2(int n)
	{
		return n+3;
	}
	
	// ���� 7) �Լ� ����
	// ���ڿ� �Ķ���� �ϳ��� �޾Ƽ� ���ڿ��� ���̰� ¦���̸� �� ���ڿ� ������ 3�踦 ��ȯ�ϰ�
	// �׷��� ������ 2�踦 �� ����� ��ȯ��
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
			System.out.println("���� �迭 : " + i + "\t");
		
		int result = func_4(nArray);
		System.out.println(result);
		System.out.println("===�迭 ������ �Լ� ȣ�� ���===");
		for(int i:nArray)
			System.out.println("���� �迭 : " + i + "\t");
		
	}

}