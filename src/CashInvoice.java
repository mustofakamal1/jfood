import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
    public CashInvoice(int id, ArrayList<Food> foods, Customer customer)
    {
        super(id, foods, customer);
    }
    
    public CashInvoice(int id, ArrayList<Food> foods, Customer customer,
    int deliveryFee)
    {
        super(id, foods, customer);
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
        for(Food foods : getFoods()) {
            if(deliveryFee > 0)
            {
                super.totalPrice = foods.getPrice() + deliveryFee;
            }
            else
            {
                super.totalPrice = foods.getPrice();
            }
        }
    }
   
    public String toString()
    {
        for(Food foods : getFoods()) {

            Date date = getDate().getTime();
            SimpleDateFormat formatter = new SimpleDateFormat("dd MMMMM yyyy");
            String formatted = formatter.format(date);
            String string =
                    "============INVOICE============\n" +
                            "ID: " + getId() + "\n" +
                            "Food: " + foods.getName() + "\n" +
                            "Date:" + date + "\n" +
                            "Customer :" + getCustomer().getName() + "\n" +
                            "Total Price: " + totalPrice + "\n" +
                            "PaymentType: " + getPaymentType();
            //System.out.println(string);
            return string;
        }
        return "";
    }
}
