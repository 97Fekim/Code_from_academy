package OOP;

public class Truck
{
	private String driverName;
	private int window;
	private int door;
	private String wife;
	
	public void setDriverName(String driver)
	{
		this.driverName = driver;
	}
	public void setWindow(int window) 
	{
		this.window = window;
	}
	public void setDoor(int door) 
	{
		this.door = door;
	}
	public void setWife(String wife) 
	{
		this.wife = wife;
	}
	public String getDriverName() 
	{
		return driverName;
	}
	public int getWindow() 
	{
		return window;
	}
	public int getDoor() 
	{
		return door;
	}
	public String getWife() 
	{
		return wife;
	}
	
	boolean isDriverMarried()
	{
		return (this.driverName.length() > 5);
	}
	
	
}
