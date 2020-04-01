import java.text.SimpleDateFormat;  
import java.util.Date; 
/**
 * Write a description of class CashInvoice here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CashInvoice extends Invoice
{
    // instance variables - replace the example below with your own
    private static final PaymentType PAYMENT_TYPE = PaymentType.Cash;
    private int deliveryFee;
    /**
     * Constructor for objects of class CashInvoice
     */
    public CashInvoice(int id, Food food, Customer customer,
    InvoiceStatus invoiceStatus)
    {
        super(id, food, customer, invoiceStatus);
    }
    
    public CashInvoice(int id, Food food, Customer customer,
    InvoiceStatus invoiceStatus, int deliveryFee)
    {
        super(id, food, customer, invoiceStatus);
        this.deliveryFee = deliveryFee;
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
    
    public int getDeliveryFee()
    {
        return deliveryFee;
    }
    
    public void setDeliveryFee(int deliveryFee)
    {
        this.deliveryFee = deliveryFee;
    }
    
    public void setTotalPrice()
    {
        if(deliveryFee > 0)
        {
            super.totalPrice = getFood().getPrice() + deliveryFee;
        }
        else
        {
            super.totalPrice = getFood().getPrice();
        }
    }
   
    public String toString()
    {
        Date date = getDate().getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("dd MMMMM yyyy");
        String formatted = formatter.format(date);
        String string =  
            "============INVOICE============\n"+
            "ID: " + getId() + "\n" +
            "Food: " + getFood().getName() + "\n" +
            "Date:" + date + "\n" +
            "Customer :" + getCustomer().getName() + "\n" +
            "Total Price: " + totalPrice + "\n" +
            "Status: " + getInvoiceStatus() + "\n" +
            "PaymentType: " + getPaymentType();
        //System.out.println(string);
        return string;
    }
}
