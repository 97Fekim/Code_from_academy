package function2;

abstract public class Record {

    String name;
    String phoneNum;
    int index;

    public Record(String n, String pn, int i){
        name = n;
        phoneNum = pn;
        index = i;
    }

    @Override
    public String toString() {
        return "Record{" +
                "name='" + name + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", index=" + index +
                '}';
    }
}
