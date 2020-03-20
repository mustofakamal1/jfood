import java.util.*;
/**
 * Seller adalah class yang berfungsi memproses informasi invoice di jFood.
 *
 * @author Mustofa Kamal
 * @version 28-02-2020
 */

public abstract class Invoice
{
    // instance variables - replace the example below with your own
    private int id;
    private Food food;
    private Calendar date;
    protected int totalPrice;
    private Customer customer;
    private InvoiceStatus invoiceStatus;

    /**
     * Constructor for objects of class Invoice.
     * <p>
     * Mengupdate id, name, email, phoneNumber, dan joinDate
     * pada object baru seller dengan nilai yang dimasukkan.
     * 
     * @param id            angka unik untuk setiap transaksi
     *                      sebagai identifier
     * @param idFood        angka unik makanan yang dipesan
     * @param date          tanggal transaksi dilakukan
     * @param customer      customer yang melakukan transaksi, 
     *                      diambil dari salah satu object dari
     *                      class Customer
     * @param totalPrice    total harga pada transaksi
     */
    public Invoice(int id, Food food, Customer customer,
    InvoiceStatus invoiceStatus)
    {
        // initialise instance variables
        Calendar now = Calendar.getInstance();
        this.id = id;
        this.food = food;
        this.date = date;
        this.customer = customer;
        this.invoiceStatus = invoiceStatus;
        this.date = now;
    }

    /**
     * Mengembalikan angka unik transaksi dari object Invoice 
     * yang bersangkutan.
     * 
     * @return  angka unik penjual dari object Invoice
     */
    public int getId()
    {
        return id;
    }
    
    /**
     * Mengembalikan angka unik makanan dari object Invoice 
     * yang bersangkutan.
     * 
     * @return  angka unik makanan dari object Invoice
     */
    public Food getFood()
    {
        return food;
    }
    
    /**
     * Mengembalikan tanggal transaksi dari object Invoice 
     * yang bersangkutan.
     * 
     * @return  tanggal transaksi dari object Invoice
     */
    public Calendar getDate()
    {
        return date;
    }
    
    /**
     * Mengembalikan total harga transaksi dari object Invoice 
     * yang bersangkutan.
     * 
     * @return  total harga transaksi dari object Invoice
     */
    public int getTotalPrice()
    {
        return totalPrice;
    }
    
    /**
     * Mengembalikan customer pada Class Customer dari object 
     * Invoice yang bersangkutan.
     * 
     * @return  customer pada Class Customer dari object Invoice
     */
    public Customer getCustomer()
    {
        return customer;
    }
    
    public abstract PaymentType getPaymentType();
    
    public InvoiceStatus getInvoiceStatus()
    {
        return invoiceStatus;
    }
    
    /**
     * Mengupdate angka unik invoice dari object Invoice yang 
     * bersangkutan.
     * 
     * @param id    angka unik invoice yang akan diupdate ke 
     *              object
     */
    public void setId(int id)
    {
        this.id = id;
    }
    
    /**
     * Mengupdate angka unik makanan dari object Invoice yang 
     * bersangkutan.
     * 
     * @param idFood    angka unik makanan yang akan diupdate ke 
     *                  object
     */
    public void setFood(Food food)
    {
        this.food = food;
    }
    
    /**
     * Mengupdate tanggal transaksi dari object Invoice yang 
     * bersangkutan.
     * 
     * @param id    tanggal transaksi yang akan diupdate ke 
     *              object
     */
    public void setDate(Calendar date)
    {
        this.date = date;
    }
    
    public void setDate(int year, int month, int dayOfMonth)
    {
        this.date = new GregorianCalendar(year, month-1, dayOfMonth);;
    }
    
    /**
     * Mengupdate total harga transaksi dari object Invoice yang 
     * bersangkutan.
     * 
     * @param id    total harga transaksi yang akan diupdate ke 
     *              object
     */
    public abstract void setTotalPrice();
    
    /**
     * Mengupdate customer pada Class Customer dari object 
     * Invoice yang bersangkutan.
     * 
     * @param id    customer pada Class Customer yang akan 
     *              diupdate ke object
     */
    public void setCustomer(Customer customer)
    {
        this.customer = customer;
    }
    
    public void setInvoiceStatus(InvoiceStatus invoiceStatus)
    {
        this.invoiceStatus = invoiceStatus;
    }
    
    public abstract void printData();
}
