package Inheritance;

public class ChildTest
{
	public static void sumb(Parent p)
	{
		
	}
	
	public static void main(String[] args)
	{
		Child c = new Child();
		c.age = 70;
		c.cname = 5;
		c.name = 67;
		System.out.println("자식나이 : " + c.age + "\n부모이름은 : " + c.name + "\n자식이름 : "+ c.cname);
		
		Dog d = new Dog();
		Parent[] p = new Parent[3];

		p[0] = new Parent();
		p[1] = new Child();
		p[2] = new Dog();
	}
}

