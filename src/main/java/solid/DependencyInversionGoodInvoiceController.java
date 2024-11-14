package solid;

public class DependencyInversionGoodInvoiceController {
    private DocumentService documentService;

    public DependencyInversionGoodInvoiceController(DocumentService documentService) {
        this.documentService = documentService;
    }

    public void makeInvoice() {
        documentService.generateDocument();
    }
}

interface DocumentService {
    void generateDocument();
}

class PDFServiceDIP implements DocumentService {
    @Override
    public void generateDocument() {
        //Generar PDF
    }
}


