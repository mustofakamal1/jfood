package mustofakamal.jfood.structure.model;
/**
 * Seller adalah class yang berfungsi memproses informasi location di jFood.
 *
 * @author Mustofa Kamal
 * @version 28-02-2020
 */
public class Location {
    // instance variables - replace the example below with your own
    private int id;
    private String province;
    private String description;
    private String city;

    /**
     * Constructor for objects of class Location.
     * <p>
     * Mengupdate id, name, email, phoneNumber, dan joinDate
     * pada object baru seller dengan nilai yang dimasukkan.
     *
     * @param id          angka unik yang dimiliki setiap seller
     *                    sebagai identifier
     * @param name        nama dari seller
     * @param email       alamat email dari seller
     * @param phoneNumber nomor telepon yang dimiliki seller
     * @param location    lokasi dari seller yang diambil dari
     *                    salah satu object dari class location
     */
    public Location(int id, String city, String province, String description) {
        // initialise instance variables
        this.id = id;
        this.city = city;
        this.province = province;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * Mengembalikan provinsi dari object Location yang
     * bersangkutan.
     *
     * @return provinsi dari object Location
     */
    public String getProvince() {
        // put your code here
        return province;
    }

    /**
     * Mengupdate provinsi dari object Location yang
     * bersangkutan.
     *
     * @param province provinsi yang akan diupdate ke object
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * Mengembalikan kota dari object Location yang bersangkutan.
     *
     * @return provinsi dari object Location
     */
    public String getCity() {
        // put your code here
        return city;
    }

    /**
     * Mengupdate kota dari object Location yang bersangkutan.
     *
     * @param city kota yang akan diupdate ke object
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Mengembalikan deskripsi dari object Location yang
     * bersangkutan.
     *
     * @return deskripsi dari object Location
     */
    public String getDescription() {
        // put your code here
        return description;
    }

    /**
     * Mengupdate deskripsi dari object Location yang
     * bersangkutan.
     *
     * @param description deskripsi yang akan diupdate ke
     *                    object
     */
    public void setDescription(String description) {
        this.description = description;
    }

    public String toString() {
        return
                "===========LOCATION============\n" +
                        "Province: " + province + "\n" +
                        "City: " + city + "\n" +
                        "Description: " + description;
    }

}
