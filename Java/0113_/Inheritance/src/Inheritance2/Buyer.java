package Inheritance2;

public class Buyer	// ��, ������ ��� ���
{
	int money = 1000;	// ���� �ݾ�
	int bonusPoint=0;	// ���ʽ� ����
	Product[] item = new Product[10];	// ���� ��ǰ�� �����ϱ� ���� �迭
	// has a ���
	
	int getMoney()
	{
		return this.money;
	}
	
	int getBonuePoint()
	{
		return this.bonusPoint;
	}
	
	Product[] getItem()
	{
		return this.item;
	}
	
	void setBonusPoint(int bonusPoint)
	{
		this.bonusPoint = bonusPoint;
	}
	
	void setItem(Product[] item)
	{
		this.item = item;
	}
	
	int i = 0;
	
	void buy(Tv p)
	{
		money -= p.getPrice();
		bonusPoint += p.getBonusPoint();
		item[i++] = p;
		System.out.println(p + "��/�� �����ϼ̽��ϴ�.");
	}
	
	void buy(Computer p)
	{
		money -= p.getPrice();
		bonusPoint += p.getBonusPoint();
		item[i++] = p;
		System.out.println(p + "��/�� �����ϼ̽��ϴ�.");
	}
	
	void buy(Audio p)
	{
		money -= p.getPrice();
		bonusPoint += p.getBonusPoint();
		item[i++] = p;
		System.out.println(p + "��/�� �����ϼ̽��ϴ�.");
	}
	
}