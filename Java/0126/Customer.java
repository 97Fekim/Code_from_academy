package function2;


enum Education {ELEMENTARY,HIGHSCHOOL,BACHELORS,MASTERS,PHD}
public class Customer {

	String name;
	String phoneNum;
	String sport;
	String team;
	double gpa;
	String subject;
	int numFriends;
	String friends;

	public Customer(String name, String phoneNum, String sport, String team,
					double gpa, String subject, int numFriends, String friends) {
		this.name = name;
		this.phoneNum = phoneNum;
		this.sport = sport;
		this.team = team;
		this.gpa = gpa;
		this.subject = subject;
		this.numFriends = numFriends;
		this.friends = friends;
	}


}
