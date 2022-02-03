package function2;

public class GpaRecord extends Record{

    String subject;

    public GpaRecord(String n, String pn, int i, String s){
        super(n, pn, i);
        subject = s;
    }

    @Override
    public String toString() {
        return super.toString() + "favorite subject is the " + subject;
    }
}
