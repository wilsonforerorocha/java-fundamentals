package solid;

/**
 * Las clases deben depender de abstracciones, no de implementaciones concretas.
 * Esto hace que el código sea más flexible y fácil de adaptar a cambios.
 */
public class DependencyInversionBadInvoiceController {

    private PDFService pdfService;


}

class PDFService {}
