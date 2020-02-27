
/**
 * Write a description of class JFood here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class JFood
{
    // instance variables - replace the example below with your own
    /**
     * Constructor for objects of class JFood
     */

    /**
     * An example of a method - replace this comment with your own
     */
    public static void main(String[] args)
    {
        Location place1 = new Location("Jakarta Timur", "Jakarta", "Rumah");
        place1.printData();
        Seller sel1 = new Seller(1, "MK", "mk@gmail.com", "+62", place1);
        sel1.printData();
        Food makanan1 = new Food(1, "Martabak", sel1, 10000, "Cepat Saji");
        Customer cs1 = new Customer(1, "Rafid", "wdhunter@gmail.com", "test", "10-11-2019");
        cs1.printData();
        Invoice inv1 = new Invoice(1, 1, "20-20-2020", cs1, 20000);
        
    }
}
