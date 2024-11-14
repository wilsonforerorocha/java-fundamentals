package solid;

public class SingleResponsibilityGoodInvoice {

    private double mount;

    public SingleResponsibilityGoodInvoice(double mount) {
        this.mount = mount;
    }

    public double calculateTax() {
        return mount * 0.16;
    }

}

class BuilderPDF {
    public void buildPDF(SingleResponsibilityGoodInvoice invoice) {
        // Lógica para generar el PDF
    }
}