import java.util.Scanner;

public class Main_class
{
	public static void main(String[] args)
	{
		String[][] words = {
				{"chair", "����"},
				{"computer", "��ǻ��"},
				{"integer", "����"},
				{"green", "���"},
				{"red", "����"},
				{"blue", "�Ķ�"}
		};
		
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i < words.length; i++)
		{
			System.out.printf("Q%d. %s�� ����? ", i + 1, words[i][0]);
			String temp = sc.next();
			if(temp.equals(words[i][1]))
			{
				System.out.println("�����Դϴ�. \n\n");
			}
			else
			{
				System.out.printf("Ʋ�Ƚ��ϴ�. ������ %s�Դϴ�. \n\n", words[i][1]);
			}
		}
		
		
		
		
	}
}