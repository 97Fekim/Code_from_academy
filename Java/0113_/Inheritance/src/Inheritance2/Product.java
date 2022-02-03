package Inheritance2;

public class Product
{
	private int price;
	private int bonusPoint;
	
	Product(int price)
	{
		this.price = price;
		bonusPoint = (int)(price/10.0);
	}
	
	Product(){}
	
	int getPrice()
	{
		return this.price;
	}
	
	int getBonusPoint()
	{
		return this.bonusPoint;
	}
	
	void setPrice(int price)
	{
		this.price = price;
	}
	
	void setBonusPoint(int bonusPoint)
	{
		this.bonusPoint = bonusPoint;
	}
	
}
