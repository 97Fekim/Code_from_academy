package advanced2;

public class Tire {
    private int price;
    private String manufacturer;
    private int weight;

    public Tire(int price, String manufacturer, int weight) {
        this.price = price;
        this.manufacturer = manufacturer;
        this.weight = weight;
    }

    /* getter setter */
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }


}
