package funtionalInterface;

public class ReceiptTest {
    public static void main(String[] args) {
        ReceiptPrinter simpleReceiptPrinter = new ReceiptPrinter() {

            @Override
            public void print(Receipt receipt) {

                System.out.println("item :\t" + receipt.item);
                System.out.println("Price :\t" + receipt.price);
                System.out.println("Disc :\t" + receipt.discount);
                System.out.println("Tax :\t" + receipt.tax);
                System.out.println("Total :\t" + computeTotal(receipt));
                System.out.println();
            }
        };

        simpleReceiptPrinter.print(new Receipt("aaa", 10000.0, 0.1, 0.2));

        ReceiptPrinter<CountyReceipt> countyReceiptReceiptPrinter = new ReceiptPrinter<CountyReceipt>() {

            @Override
            public void print(CountyReceipt receipt) {
                System.out.println("item :\t" + receipt.item);
                System.out.println("Price :\t" + receipt.price);
                System.out.println("Disc :\t" + receipt.discount);
                System.out.println("Tax :\t" + receipt.tax);
                System.out.println("Total :\t\n" + computeTotal(receipt));
            }

            public double computeTotal(CountyReceipt receipt){
                double discountedPrice = receipt.price
                        - (receipt.price * receipt.discount);
                return discountedPrice
                        + (discountedPrice * receipt.tax)
                        + (discountedPrice * receipt.countyTax);
            }
        };

        countyReceiptReceiptPrinter.print((new CountyReceipt((new Receipt("shirt",20.0,0.05,0.07)),0.04)));
    }
}