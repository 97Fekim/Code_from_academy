package vo;

public class Scores {
	private int tel;
	private String address;
	private String name;
	private int kor;
	private int eng;
	private int math;
	private String grade;
	
	public String calGrade() {
		int avg = (this.kor + this.eng + this.math) /3;
		
		if(avg >= 90)
			return "수";
		else if(avg >= 80)
			return "우";
		else if(avg >= 70)
			return "미";
		else if (avg >= 60)
			return "양";
		else
			return "가";
	}
	
	public int getTel() {
		return tel;
	}
	public Scores setTel(int tel) {
		this.tel = tel;
		return this;
	}
	public String getAddress() {
		return address;
	}
	public Scores setAddress(String address) {
		this.address = address;
		return this;
	}
	public String getName() {
		return name;
	}
	public Scores setName(String name) {
		this.name = name;
		return this;
	}
	public int getKor() {
		return kor;
	}
	public Scores setKor(int kor) {
		this.kor = kor;
		return this;
	}
	public int getEng() {
		return eng;
	}
	public Scores setEng(int eng) {
		this.eng = eng;
		return this;
	}
	public int getMath() {
		return math;
	}
	public Scores setMath(int math) {
		this.math = math;
		return this;
	}
	public String getGrade() {
		return grade;
	}
	public Scores setGrade(String grade) {
		this.grade = grade;
		return this;
	}

	
}
