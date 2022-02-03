package Jungsuck;

public class Class_Truck {
	private int door;
	private String name;
	private int price;
	private int handle;
	
	public Class_Truck(int door, String name, int price, int handle) 
	{
		super();
		this.door = door;
		this.name = name;
		this.price = price;
		this.handle = handle;
	}

	public int getDoor() {
		return door;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public int getHandle() {
		return handle;
	}

}
