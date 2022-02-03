package function2;

public class SportRecord extends Record{

    String team;

    public SportRecord(String n, String pn, int i, String t){
        super(n, pn, i);
        team = t;
    }

    @Override
    public String toString() {
        return super.toString() + "favorite team is the " + team;
    }
}
