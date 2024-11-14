package solid;

/*
OCP -> Usar una estrategia de descuento con una interfaz
para permitir agregar nuevos descuentos sin modificar l
a clase original.
 */
public class OpenCloseGoodDiscountCalculator {

    public double calcular(Invoice invoice, DiscountStrategy discountStrategy) {
        return discountStrategy.applyDiscount(invoice);
    }

}

interface DiscountStrategy {
    double applyDiscount(Invoice invoice);
}

class VIPDiscount implements DiscountStrategy {
    public double applyDiscount(Invoice invoice) {
        return invoice.getAmount() * 0.2;
    }
}

class RegularDiscount implements DiscountStrategy {
    public double applyDiscount(Invoice invoice) {
        return invoice.getAmount() * 0.1;
    }
}
