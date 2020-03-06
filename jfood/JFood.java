    
/**
 * Write a description of class JFood here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class JFood
{
    /**
     * An example of a method - replace this comment with your own
     */
    public static void main(String[] args)
    {
        //CS Modul 1&2
        //Location place1 = new Location("Jakarta Timur", "Jakarta", "Rumah");
        //place1.printData();
        //Seller sel1 = new Seller(1, "MK", "mk@gmail.com", "+62", place1);
        //sel1.printData();
        //Food makanan1 = new Food(1, "Martabak", sel1, 10000, "Cepat Saji");
        //Customer cs1 = new Customer(1, "Rafid", "wdhunter@gmail.com", "test", "10-11-2019");
        //cs1.printData();
        //Invoice inv1 = new Invoice(1, 1, "20-20-2020", cs1, 20000);
        
        //Post test Modul 2
        //Location loc1 = new Location("Jakarta Timur", "Jakarta", "Tempat Lahir");
        //Seller seller1 = new Seller(1706043020, "Mustofa Kamal", "mustofa.alhaddad@gmail.com", "085155499891", loc1);
        //Food makan1 = new Food(100, "Nasi", seller1, 1000, "Cepat");
        //Customer css1 = new Customer(1, "Dimas", "dimunter@gmail.com", "pass", "10-11-2019");
        //Invoice trans1 = new Invoice(2, 100, "20-20-2020", css1, 20000);
        //seller1.getName();
        //seller1.setName("Achmad Fatur Rizki");
        //seller1.getName();
        //makan1.printData();
        
        //CS Modul 3
        Location loc3 = new Location("Jakarta Timur", "Jakarta", "Tempat Lahir");
        Seller sel3 = new Seller(1706043020, "Mustofa Kamal", "mustofa.alhaddad@gmail.com", "085155499891", loc3);
        Food makan3 = new Food(100, "Sushi", sel3, 1000, FoodCategory.Japanese);
        makan3.printData();
    
        //PostTest Modul 3
        Food makan33 = new Food(1290, "Mie", sel3, 6800, FoodCategory.Beverages);
        Customer cust33 = new Customer(33, "Pembeli", "Pembeli@gmail.com", "Pembelian", "10-11-2020");
        Invoice inv33 = new Invoice(3300, makan33.getId(), "12-11-2020", cust33, makan33.getPrice(), InvoiceStatus.Finished);
        inv33.printData();
    }
}
