package OOP;

public class Score
{
	private int math;	// �������(Score Ŭ������ ���)
	private int eng;	// 
	private int korea;
	
	// �� Ŭ������ ��������� private�̶� �� Ŭ������ ��������� ���ٺҰ���
	// �� Ŭ������ ��ü�� ���� ����ϰ��� �ϴ� Ŭ�������� ����Ϸ���??
	
	// setter(����ϰ��� �ϴ� Ŭ�������� ����ϰ��� �ϴ� Ŭ������ ��ü�� ��������� ���� �����ϴ� �Լ�)
	// set = write = store
	// setter�� ����� ���
	// ��������� ù ���ڸ� �빮�ڷ� �ϰ�, get�� ���δ�.
	// �� setter(�Լ�)�� �Ķ������ ���� �޾Ƽ� ��������� ���� ����.
	// ��ȯ���� ����. (void)

	// getter(Ŭ�������� ��ü�� ��������� ���� �о�ö� ����ϴ� �Լ�)
	// get = read
	// getter ����� ���
	// ��������� ù���ڸ� �빮�ڷ� �ϰ� get�� ���δ�.
	// �� getter(�Լ�)�� �Ķ���Ͱ� ����, ��ȯ���� ��������̴�.
	
	int getMath()
	{
		return this.math;
	}
	
	int getEng()
	{
		return this.eng;
	}
	
	int getKorea()
	{
		return this.korea;
	}
	
	void setMath(int math)
	{
		this.math = math;
	}
		
	void setEng(int eng)
	{
		this.eng = eng;
	}
	
	void setKorea(int korea)
	{
		this.korea = korea;
	}
	
	
	/* Ŭ���� ���� �ִ� �Լ�(�޼ҵ�) */
	public int g()
	{
		return 7;
	}
	
	
	
}