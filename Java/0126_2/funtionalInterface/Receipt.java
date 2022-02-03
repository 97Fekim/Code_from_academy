package funtionalInterface;

public class Receipt {  // Value Object

    String item;
    double price;
    double discount;
    double tax;


    Receipt (String i, double a, double d, double s){
        this.item = i;
        price = a;
        discount = d;
        tax = s;
    }

    Receipt(Receipt r){
        item = r.item;
        price = r.price;
        discount = r.discount;
        tax = r.tax;
    }

}
