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
		System.out.println("�ڽĳ��� : " + c.age + "\n�θ��̸��� : " + c.name + "\n�ڽ��̸� : "+ c.cname);
		
		Dog d = new Dog();
		Parent[] p = new Parent[3];

		p[0] = new Parent();
		p[1] = new Child();
		p[2] = new Dog();
	}
}
