package Map;

public class Green {
    private int tire;
    private String address;
    private int price;
    private String name;

    Green(){}

    public Green(int tire, String address, int price, String name) {
        this.tire = tire;
        this.address = address;
        this.price = price;
        this.name = name;
    }

    public int getTire() {
        return tire;
    }

    public void setTire(int tire) {
        this.tire = tire;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
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

    @Override
    public String toString() {
        return "Green{" +
                "tire=" + tire +
                ", address='" + address + '\'' +
                ", price=" + price +
                ", name='" + name + '\'' +
                '}';
    }
}
