package solid;

public class LiskovSubstitutionGoodEmployee {
}

abstract class Worker {
    abstract double calculatePay();
}

class Employee extends Worker {

    @Override
    double calculatePay() {
        return 2000.0;
    }
}

class ExternalEmployeeLs extends Worker {

    @Override
    double calculatePay() {
        return 100 * 20; // Pago por horas
    }
}