
/**
 * Write a description of class Promo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Promo
{
    // instance variables - replace the example below with your own
    private int id;
    private String code;
    private int discount;
    private int minPrice;
    private boolean active;

    /**
     * Constructor for objects of class Promo
     */
    public Promo(int id, String code, int discount, int minPrice, boolean 
    active)
    {
        // initialise instance variables
        this.id = id;
        this.code = code;
        this.discount = discount;
        this.minPrice = minPrice;
        this.active = active;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int getId()
    {
        // put your code here
        return id;
    }
    
    public String getCode()
    {
        // put your code here
        return code;
    }
    
    public int getDiscount()
    {
        // put your code here
        return discount;
    }
    
    public int getMinPrice()
    {
        // put your code here
        return minPrice;
    }
    
    public boolean getActive()
    {
        // put your code here
        return active;
    }
    
    public void setId(int id)
    {
        this.id = id;
    }
    
    public void setCode(String code)
    {
        this.code = code;
    }
    
    public void setDiscount(int discount)
    {
        this.discount = discount;
    }
    
    public void setMinPrice(int MinPrice)
    {
        this.minPrice = minPrice;
    }
    
    public void setActive(boolean active)
    {
        this.active = active;
    }
    
    public void printData()
    {
        System.out.println("============PROMO============");
        System.out.println("ID: " + id);
        System.out.println("Code: " + code);
        System.out.println("Discount: " + discount);
        System.out.println("Harga Minimal: " + minPrice);
        System.out.println("Status: " + active);
    }
}
