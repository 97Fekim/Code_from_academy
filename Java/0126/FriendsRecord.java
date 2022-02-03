package function2;

public class FriendsRecord extends Record{

    String friends;

    public FriendsRecord(String n, String pn, int i, String f){
        super(n, pn, i);
        friends = f;
    }

    @Override
    public String toString() {
        return super.toString() + "favorite friends are " + friends;
    }
}
