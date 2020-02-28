
/**
 * Customer adalah class yang berfungsi memproses informasi 
 * customer di jFood.
 *
 * @author Mustofa Kamal
 * @version 28-02-2020
 */
public class Customer
{
    // instance variables
    private int id;
    private String name;
    private String email;
    private String password;
    private String joinDate;
    
    /**
     * Constructor for objects of class Customer.
     * <p>
     * Mengupdate id, nama, alamat email, password, dan tanggal 
     * bergabung pada object baru Customer dengan nilai yang 
     * dimasukkan.
     * 
     * @param id        angka unik yang dimiliki setiap customer 
     *                  sebagai identifier
     * @param name      nama dari customer
     * @param email     alamat email dari customer
     * @param password  password yang digunakan customer untuk 
     *                  login
     * @param joinDate  tanggal mulai menjadi customer atau 
     *                  membuat akun
     */
    public Customer(int id, String name, String email, String password, String joinDate)
    {
        // initialise instance variables
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.joinDate = joinDate;
    }

    /**
     * Mengembalikan id dari object Customer yang 
     * bersangkutan.
     * 
     * @return  angka unik dari object customer
     */
    public int getId()
    {
        return id;
    }
    
    /**
     * Mengembalikan nama dari object Customer yang 
     * bersangkutan.
     * 
     * @return  nama dari object customer
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Mengembalikan email dari object Customer yang 
     * bersangkutan.
     * 
     * @return  email dari object customer 
     */
    public String getEmail()
    {
        return email;
    }
    
    /**
     * Mengembalikan password dari object Customer yang 
     * bersangkutan.
     * 
     * @return  password dari object customer
     */
    public String getPassword()
    {
        return password;
    }
    
    /**
     * Mengembalikan tanggal bergabungs dari object Customer yang 
     * bersangkutan.
     * 
     * @return  tanggal bergabung dari object customer
     */
    public String getJoinDate()
    {
        return joinDate;
    }
    
    /**
     * Mengupdate angka unik dari object Customer yang 
     * bersangkutan.
     * 
     * @param id    angka unik customer yang akan diupdate ke object
     */
    public void setId(int id)
    {
        this.id = id;
    }
    
    /**
     * Mengupdate nama dari object Customer yang 
     * bersangkutan.
     * 
     * @param name  nama customer yang akan diupdate ke object
     */
    public void setName(String name)
    {
        this.name = name;
    }
    
    /**
     * Mengupdate email dari object Customer yang 
     * bersangkutan.
     * 
     * @param email email customer yang akan diupdate ke object
     */
    public void setEmail(String email)
    {
        this.email = email;
    }
    
    /**
     * Mengupdate password dari object Customer yang 
     * bersangkutan.
     * 
     * @param password  password customer yang akan diupdate ke 
     *                  object
     */
    public void setPassword(String Password)
    {
        this.password = password;
    }
    
    /**
     * Mengupdate tanggal bergabung dari object Customer yang 
     * bersangkutan.
     * 
     * @param joinDate  tanggal bergabung customer yang akan diupdate 
     *                  ke object
     */
    public void setJoinDate(String joinDate)
    {
        this.joinDate = joinDate;
    }
    
    /**
     * Menampilkan nama customer dari object customer yang 
     * bersangkutan.
     */
    public void printData()
    {
        System.out.println(name);
    }
}
