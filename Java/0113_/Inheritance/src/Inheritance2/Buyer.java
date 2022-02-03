package Inheritance2;

public class Buyer	// 고객, 물건을 사는 사람
{
	int money = 1000;	// 소유 금액
	int bonusPoint=0;	// 보너스 점수
	Product[] item = new Product[10];	// 고객의 제품을 저장하기 위한 배열
	// has a 상속
	
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
		System.out.println(p + "을/를 구매하셨습니다.");
	}
	
	void buy(Computer p)
	{
		money -= p.getPrice();
		bonusPoint += p.getBonusPoint();
		item[i++] = p;
		System.out.println(p + "을/를 구매하셨습니다.");
	}
	
	void buy(Audio p)
	{
		money -= p.getPrice();
		bonusPoint += p.getBonusPoint();
		item[i++] = p;
		System.out.println(p + "을/를 구매하셨습니다.");
	}
	
}