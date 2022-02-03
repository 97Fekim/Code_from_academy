package advanced2;

public class Car {
    private int price;
    private int total;
    private String name;
    private String driver;
    private Tire tire;
    private Green[] gs = new Green[4];

    public Car(int price, int total, String name, String driver, Tire tire) {
        this.price = price;
        this.total = total;
        this.name = name;
        this.driver = driver;
        this.tire = tire;
    }

    public Tire getTire() {
        return tire;
    }

    public void setTire(Tire tire) {
        this.tire = tire;
    }

    public Green[] getGs() {
        return gs;
    }

    public void setGs(Green[] gs) {
        this.gs = gs;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
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
