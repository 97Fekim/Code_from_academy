import java.util.*;

public class Class_main 
{
	public static void main(String[] args) 
	{
		int[][] score = {
				{100,100,100},
				{20,20,20},
				{30,30,30},
				{40,40,40}
		};
		
		int num = 0;
		for(int i = 0; i < score.length; ++i)
			for(int j = 0; j < score[i].length; ++j)
			{
				System.out.printf("score[%d][%d]=%d\n", i,j,score[i][j]);
			}
		
		int sum = 0;
		
		for(int[] i:score)
			for(int j: i)
				sum += j;
		
		System.out.println("???? : "+sum);
		
	}
}
