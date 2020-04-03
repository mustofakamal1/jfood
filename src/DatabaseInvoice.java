import java.util.ArrayList;

/**
 * Write a description of class DatabaseInvoice here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DatabaseInvoice {
    // instance variables - replace the example below with your own
    private static ArrayList<Invoice> INVOICE_DATABASE = new ArrayList<>();
    private static int lastId = 0;

    /**
     * Constructor for objects of class DatabaseInvoice
     */
    public DatabaseInvoice() {

    }

    public static ArrayList<Invoice> getInvoiceDatabase() {
        return INVOICE_DATABASE;
    }

    public static int getLastId() {
        return lastId;
    }

    public static Invoice getInvoiceById(int id) {
        for (Invoice invoice : INVOICE_DATABASE) {
            if (invoice.getId() == id) {
                return invoice;
            }
        }
        return null;
    }

    public static ArrayList<Invoice> getInvoiceByCustomer(int customerId) {
        ArrayList<Invoice> invoices = new ArrayList<>();
        for (Invoice invoice : INVOICE_DATABASE) {
            if (invoice.getCustomer().getId() == customerId) {
                invoices.add(invoice);
            }
        }
        if(invoices.size() > 0) {
            return invoices;
        }
        return null;
    }

    public boolean addInvoice(Invoice invoice) {
        for (Invoice invoices : INVOICE_DATABASE) {
            if (invoices.getCustomer().equals(invoice.getCustomer())) {
                if(invoices.getInvoiceStatus().equals(InvoiceStatus.Ongoing)){
                    return false;
                }
            }
        }
        INVOICE_DATABASE.add(invoice);
        lastId = invoice.getId();
        return true;
    }

    public boolean removeInvoice(int id) {
        for (Invoice invoice : INVOICE_DATABASE) {
            if (invoice.getId() == id) {
                INVOICE_DATABASE.remove(invoice);
                return true;
            }
        }
        return false;
    }

    public boolean changeInvoiceStatus(int id, InvoiceStatus invoiceStatus) {
        for (Invoice invoice : INVOICE_DATABASE) {
            if (invoice.getId() == id) {
                if(invoice.getInvoiceStatus().equals(InvoiceStatus.Ongoing)){
                    invoice.setInvoiceStatus(invoiceStatus);
                    INVOICE_DATABASE.set(INVOICE_DATABASE.indexOf(invoice), invoice);
                    return true;
                }
            }
        }
        return false;
    }
}
