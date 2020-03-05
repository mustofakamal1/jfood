
/**
 * Seller adalah class yang berfungsi memproses informasi semua food di jFood.
 *
 * @author Mustofa Kamal
 * @version 28-02-2020
 */
public class DatabaseFood
{
    // instance variables - replace the example below with your own
    private static String[] listFood;

    /**
     * Constructor for objects of class DatabaseFood.
     */
    public DatabaseFood()
    {
        // initialise instance variables
    }

    /**
     * Mengembalikan nilai true untuk menunjukkan method 
     * dieksekusi hingga selesai.
     * 
     * @param food  food pada Class food yang akan diproses di 
     *              method ini
     * @return      true yang menunjukkan 1 atau benar
     */
    public static boolean addFood(Food food)
    {
       return true;
    }
    
    /**
     * Mengembalikan nilai true untuk menunjukkan method 
     * dieksekusi hingga selesai.
     * 
     * @param food  food pada Class food yang akan diproses di 
     *              method ini
     * @return      true yang menunjukkan 1 atau selesai
     */
    public static boolean removeFood(Food food)
    {
        return true;
    }
    
    /**
     * Mengembalikan nilai null untuk menunjukkan food tidak
     * tersedia di database makanan. 
     * 
     * @param food  food pada Class food yang akan diproses di 
     *              method ini
     * @return      null yang menunjukkan kosong atau tidak ada
     */
    public static Food getFood()
    {
        return null;
    }
    
    /**
     * Mengembalikan daftar makanan yang ada di database makanan. 
     * 
     * @return      daftar makanan yang ada
     */
    public static String[] getListFood()
    {
        return listFood;
    }
}
