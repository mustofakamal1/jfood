
/**
 * Seller adalah class yang berfungsi memproses informasi invoice di jFood.
 *
 * @author Mustofa Kamal
 * @version 28-02-2020
 */

public class Invoice
{
    // instance variables - replace the example below with your own
    private int id;
    private int idFood;
    private String date;
    private int totalPrice;
    private Customer customer;

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
    public Invoice(int id, int idFood, String date, Customer customer, int totalPrice)
    {
        // initialise instance variables
        this.id = id;
        this.idFood = idFood;
        this.date = date;
        this.customer = customer;
        this.totalPrice = totalPrice;
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
    public int getIdFood()
    {
        return idFood;
    }
    
    /**
     * Mengembalikan tanggal transaksi dari object Invoice 
     * yang bersangkutan.
     * 
     * @return  tanggal transaksi dari object Invoice
     */
    public String getDate()
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
    public void setIdFood(int idFood)
    {
        this.idFood = idFood;
    }
    
    /**
     * Mengupdate tanggal transaksi dari object Invoice yang 
     * bersangkutan.
     * 
     * @param id    tanggal transaksi yang akan diupdate ke 
     *              object
     */
    public void setDate(String date)
    {
        this.date = date;
    }
    
    /**
     * Mengupdate total harga transaksi dari object Invoice yang 
     * bersangkutan.
     * 
     * @param id    total harga transaksi yang akan diupdate ke 
     *              object
     */
    public void setTotalPrice(int totalPrice)
    {
        this.totalPrice = totalPrice;
    }
    
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
}
