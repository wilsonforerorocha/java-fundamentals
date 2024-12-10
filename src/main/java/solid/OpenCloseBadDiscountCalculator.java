package solid;

public class OpenCloseBadDiscountCalculator {

    public double getDiscount(Invoice invoice, Customer customer) {
        if (customer.isVip()) {
            return invoice.getAmount() * 0.2;
        } else {
            return invoice.getAmount() * 0.1;
        }
    }

}

class Invoice {

   public double getAmount() {
       return 0;
   }

}
class Customer {
    public boolean isVip() {
        return true;
    }
}