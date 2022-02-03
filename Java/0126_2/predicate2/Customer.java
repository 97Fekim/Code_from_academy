package predicate2;

enum Education {ELEMENTARY, HIGHSCHOOL, BACHELORS, MASTERS, PHD}

public class Customer {
    String gender;
    String state;
    int age;
    Education ed;

    public Customer(){}
    public Customer(String g, String st, int a, Education e){
        gender = g;
        state = st;
        age = a;
        ed = e;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "gender='" + gender + '\'' +
                ", state='" + state + '\'' +
                ", age=" + age +
                ", ed=" + ed +
                '}';
    }


}
