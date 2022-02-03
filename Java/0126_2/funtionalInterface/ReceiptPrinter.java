package funtionalInterface;

@FunctionalInterface
public interface ReceiptPrinter<X extends Receipt> {    // X는 Receipt 타입의 자식만 들어올 수 있음

    // Type Restrictions(제약)을 가진 Generic Functional Interface
    void print(X receipt);    // 추상화 되어있는 추상메서드 하나. 자식에서 필수로 override 해야함.

    private double getDiscountedPrice(X receipt){
        return receipt.price
                - (receipt.price * receipt.discount);
    }

    default double computeTotal(X receipt){
        double discountedPrice = getDiscountedPrice(receipt);
        return discountedPrice + (discountedPrice * receipt.tax);
    }

}
