
/**
 * Seller adalah class yang berfungsi memproses informasi location di jFood.
 *
 * @author Mustofa Kamal
 * @version 28-02-2020
 */
public class Location
{
    // instance variables - replace the example below with your own
    private String province;
    private String description;
    private String city;

    /**
     * Constructor for objects of class Location.
     * <p>
     * Mengupdate id, name, email, phoneNumber, dan joinDate
     * pada object baru seller dengan nilai yang dimasukkan.
     * 
     * @param id            angka unik yang dimiliki setiap seller 
     *                      sebagai identifier
     * @param name          nama dari seller
     * @param email         alamat email dari seller
     * @param phoneNumber   nomor telepon yang dimiliki seller 
     * @param location      lokasi dari seller yang diambil dari 
     *                      salah satu object dari class location
     */
    public Location(String city, String province, String description)
    {
        // initialise instance variables
        this.city = city;
        this.province = province;
        this.description = description;
    }

    /**
     * Mengembalikan provinsi dari object Location yang 
     * bersangkutan.
     * 
     * @return  provinsi dari object Location
     */
    public String getProvince()
    {
        // put your code here
        return province;
    }
    
    /**
     * Mengembalikan kota dari object Location yang bersangkutan.
     * 
     * @return  provinsi dari object Location
     */
    public String getCity()
    {
        // put your code here
        return city;
    }
    
    /**
     * Mengembalikan deskripsi dari object Location yang 
     * bersangkutan.
     * 
     * @return  deskripsi dari object Location
     */
    public String getDescription()
    {
        // put your code here
        return description;
    }
    
    /**
     * Mengupdate provinsi dari object Location yang 
     * bersangkutan.
     * 
     * @param province  provinsi yang akan diupdate ke object
     */
    public void setProvince(String province)
    {
        this.province = province;
    }
    
    /**
     * Mengupdate kota dari object Location yang bersangkutan.
     * 
     * @param city  kota yang akan diupdate ke object
     */
    public void setCity(String city)
    {
        this.city = city;
    }
    
    /**
     * Mengupdate deskripsi dari object Location yang 
     * bersangkutan.
     * 
     * @param description   deskripsi yang akan diupdate ke 
     *                      object
     */
    public void setDescription(String description)
    {
        this.description = description;
    }
    
    /**
     * Menampilkan nama provinsi dari object Location yang 
     * bersangkutan.
     */
    public void printData()
    {
        System.out.println(province);
    }
}
