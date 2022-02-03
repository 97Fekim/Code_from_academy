package advanced;

public class Red {
    private int price;
    private String name;
    private int math;
    private int eng;
    private int korea;
    private float total;
    private String address;

    public Red(int price, String name, int math, int eng, int korea, float total, String address) {
        this.price = price;
        this.name = name;
        this.math = math;
        this.eng = eng;
        this.korea = korea;
        this.total = total;
        this.address = address;
    }



    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getEng() {
        return eng;
    }

    public void setEng(int eng) {
        this.eng = eng;
    }

    public int getKorea() {
        return korea;
    }

    public void setKorea(int korea) {
        this.korea = korea;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
