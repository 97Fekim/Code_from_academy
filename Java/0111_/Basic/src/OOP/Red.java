package OOP;

public class Red
{
	
	private String name;
	private int num;
	private int total;
	private int migum;
	private float busan;
	
	String getName()
	{
		return this.name;
	}
	
	void setName(String name)
	{
		this.name = name;
	}
		
	boolean calcTotal(int num)
	{
		if((3*num)%2 == 0)
			return true;
		else
			return false;
	}
	
}
