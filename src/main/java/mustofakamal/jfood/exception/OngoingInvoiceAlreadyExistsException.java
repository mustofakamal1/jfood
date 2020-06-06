package mustofakamal.jfood.exception;

import mustofakamal.jfood.structure.model.Invoice;

public class OngoingInvoiceAlreadyExistsException extends Exception {

    private Invoice invoice_error;

    public OngoingInvoiceAlreadyExistsException (Invoice invoice_input) {
        super("Ongoing Invoice : ");
        this.invoice_error = invoice_input;
    }

    public String getMessage() {
        return super.getMessage() + "by " + invoice_error.getCustomer().getName() + "dengan id: " +
                invoice_error.getCustomer().getId() + " already exists.";
    }
}
