
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
    public CashlessInvoice(int id, Food food, String date, Customer customer,
    InvoiceStatus invoiceStatus)
    {
        super(id, food, date, customer, invoiceStatus);
    }
    
    public CashlessInvoice(int id, Food food, String date, Customer customer,
    InvoiceStatus invoiceStatus, Promo promo)
    {
        super(id, food, date, customer, invoiceStatus);
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
    
    public void printData()
    {
        System.out.println("============INVOICE============");
        System.out.println("ID: " + getId());
        System.out.println("Food: " + getFood().getName());
        System.out.println("Date: " + getDate());
        System.out.println("Customer: " + getCustomer().getName());
        if(!(getPromo() == null || promo.getActive() == false ||  
        getFood().getPrice() < promo.getMinPrice()))
        {
            System.out.println("Promo: " + promo.getCode());
        }
        System.out.println("Total Price: " + totalPrice);
        System.out.println("Status: " + getInvoiceStatus());
        System.out.println("PaymentType: " + getPaymentType());
    }
}