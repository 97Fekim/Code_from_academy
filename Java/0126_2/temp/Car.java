package temp;

public class Car {
    private int tire;
    private int price;
    private String name;
    private String driver;

    /* constructor */
    public Car(){}
    public Car(int tire, int price, String name, String driver) {
        this.tire = tire;
        this.price = price;
        this.name = name;
        this.driver = driver;
    }

    @Override
    public String toString() {
        return "Car{" +
                "tire=" + tire +
                ", price=" + price +
                ", name='" + name + '\'' +
                ", driver='" + driver + '\'' +
                '}';
    }

    public int getTire() {
        return tire;
    }

    public void setTire(int tire) {
        this.tire = tire;
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

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }


}
