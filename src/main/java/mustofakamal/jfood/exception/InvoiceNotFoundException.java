package mustofakamal.jfood.exception;

/**
 * Class InvoiceNotFoundException adalah class yang berfungsi
 * memberikan peringatan invoice tidak ditemukan.
 *
 * @author Mustofa Kamal
 * @version 07-06-2020
 */
public class InvoiceNotFoundException extends Exception {

    private int invoice_error;

    public InvoiceNotFoundException (int invoice_input) {
        super("Invoice ID: ");
        this.invoice_error = invoice_input;
    }

    public String getMessage() {
        return super.getMessage() + invoice_error + " not found";
    }
}