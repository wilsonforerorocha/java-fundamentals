package solid;

class SingleResponsibilityBadInvoice {
    private double mount;

    public SingleResponsibilityBadInvoice(double mount) {
        this.mount = mount;
    }

    public double calculateTax() {
        return mount * 0.16;
    }

    public void buildPDF() {
        // Lógica para generar un PDF de la factura
    }
}