import java.text.SimpleDateFormat;  
import java.util.Date;
import java.util.*; 
/**
 * Write a description of class CashlessInvoice here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CashlessInvoice extends Invoice
{
    // instance variables - replace the example below with your own
    private static final PaymentType PAYMENT_TYPE = PaymentType.Cashless;
    private Promo promo;

    /**
     * Constructor for objects of class CashlessInvoice
     */
    public CashlessInvoice(int id, Food food, Customer customer,
    InvoiceStatus invoiceStatus)
    {
        super(id, food, customer, invoiceStatus);
    }
    
    public CashlessInvoice(int id, Food food, Customer customer,
    InvoiceStatus invoiceStatus, Promo promo)
    {
        super(id, food, customer, invoiceStatus);
        this.promo = promo;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public PaymentType getPaymentType()
    {
        return PAYMENT_TYPE;
    }
    
    public Promo getPromo()
    {
        return promo;
    }
    
    public void setPromo(Promo promo)
    {
        this.promo = promo;
    }
    
    public void setTotalPrice()
    {
        if(promo != null && promo.getActive() == true && getFood().getPrice() 
        > promo.getMinPrice())
        {
            super.totalPrice = getFood().getPrice() - promo.getDiscount();
        }
        else
        {
            super.totalPrice = getFood().getPrice();
        }
    }

    public String toString()
    {
        String string = "";
        if(!(getPromo() == null || promo.getActive() == false ||  
        getFood().getPrice() < promo.getMinPrice()))
        {
            Date date = getDate().getTime();
            SimpleDateFormat formatter = new SimpleDateFormat("dd MMMMM yyyy");
            String formatted = formatter.format(date);
            string =  
            "============INVOICE============\n"+
            "ID: " + getId() + "\n" +
            "Food: " + getFood().getName() + "\n" +
            "Date:" + date + "\n" +
            "Customer :" + getCustomer().getName() + "\n" +
            "Promo: " + promo.getCode() + "\n" +
            "Total Price: " + totalPrice + "\n" +
            "Status: " + getInvoiceStatus() + "\n" +
            "PaymentType: " + getPaymentType();
        }
        else{
            Date date = getDate().getTime();
            SimpleDateFormat formatter = new SimpleDateFormat("dd MMMMM yyyy");
            String formatted = formatter.format(date);
            string =  
            "============INVOICE============\n"+
            "ID: " + getId() + "\n" +
            "Food: " + getFood().getName() + "\n" +
            "Date:" + date + "\n" +
            "Customer :" + getCustomer().getName() + "\n" +
            "Total Price: " + totalPrice + "\n" +
            "Status: " + getInvoiceStatus() + "\n" +
            "PaymentType: " + getPaymentType();
        }
        //System.out.println(string);
        return string;
    }
}