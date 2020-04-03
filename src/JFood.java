/**
 * Write a description of class JFood here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class JFood {
    /**
     * An example of a method - replace this comment with your own
     */
    public static void main(String[] args) {
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
//        Location loc3 = new Location("Jakarta Timur", "Jakarta", "Tempat Lahir");
//        Seller sel3 = new Seller(1706043020, "Mustofa Kamal", "mustofa.alhaddad@gmail.com", "085155499891", loc3);
        //Food makan3 = new Food(100, "Sushi", sel3, 1000, FoodCategory.Japanese);
        //makan3.printData();

        //PostTest Modul 3
        //Food makan33 = new Food(1290, "Mie", sel3, 6800, FoodCategory.Beverages);
        //Customer cust33 = new Customer(33, "Pembeli", "Pembeli@gmail.com", "Pembelian", "10-11-2020");
        //Invoice inv33 = new Invoice(3300, makan33.getId(), "12-11-2020", cust33, makan33.getPrice(), InvoiceStatus.Finished);
        //inv33.printData();

        //Modul 4
        //Customer c4 = new Customer(1, "Andi", "@gmail.com", "Beli", "12-03-2020");
//        Promo p4 = new Promo(1, "CobaNih", 4000, 10000, true);
//        Food f4 = new Food(1, "Martabak", sel3, 15000, FoodCategory.Beverages);
        //Food f44 = new Food(2, "Kacang", sel3, 5000, FoodCategory.Beverages);
        // CashlessInvoice ci4 = new CashlessInvoice(1, f4, "12-30-2020", c4, InvoiceStatus.Ongoing);
        // CashlessInvoice ci44 = new CashlessInvoice(1, f4, "12-30-2020", c4, InvoiceStatus.Ongoing, p4);
        // CashlessInvoice ci444 = new CashlessInvoice(1, f44, "12-30-2020", c4, InvoiceStatus.Ongoing, p4);
        // ci4.setTotalPrice();
        // ci44.setTotalPrice();
        // ci444.setTotalPrice();
        // ci4.printData();
        // ci44.printData();
        // ci444.printData();

        //Modul 4 - Post Test
        //CashInvoice cas4 = new CashInvoice(1, f4, "13-3-2020", c4, InvoiceStatus.Finished);
        //CashInvoice cas44 = new CashInvoice(1, f4, "13-3-2020", c4, InvoiceStatus.Finished, 3500);
        //cas4.setTotalPrice();
        //cas44.setTotalPrice();
        //cas4.printData();
        //cas44.printData();
        //Modul 5
//        Calendar k1 = new GregorianCalendar(2020, 3, 20);
//        Customer c5 = new Customer(1, "Andi", "saya..gmail@gmail.com", "pass1234", k1);
//        Customer c55 = new Customer(2, "saya", "saya.saya@gmail.com", "pas1SA1#Ss", 2020,7,31);
//        Customer c555 = new Customer(3, "Ai", "kamal_&&@gmail.com", "pas9SA-1");
        //System.out.println(c5.toString());
        //System.out.println(c55.toString());
        //System.out.println(c555.toString());
//        c5.setEmail("test@google.com");
//        c5.setPassword("pas1SA1#Ss");
        //System.out.println(c5.toString());


//        Invoice cas4 = new CashInvoice(1, f4, c5, InvoiceStatus.Finished);
//        Invoice ci4 = new CashlessInvoice(1, f4, c5, InvoiceStatus.Ongoing, p4);
//        cas4.setTotalPrice();
//        ci4.setTotalPrice();
//        System.out.println(cas4.toString());
//        System.out.println(ci4.toString());

        //Modul 6
        Location loc6 = new Location("Jakarta Timur", "Jakarta", "Rumah");
        DatabaseSeller.addSeller(new Seller(DatabaseSeller.getLastId() + 1, "Mulya",
                "mulya@gmail.com", "0812345678", loc6));
        DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId() + 1, "Mustofa Kamal",
                "mustofa.kamal71@ui.ac.id", "pFss1234"));
        DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId() + 1, "Mustofa Kamal",
                "mustofa.kamal71@ui.ac.id", "pSass1434"));
        DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId() + 1, "Djati Pradana",
                "djati.pradana@ui.ac.id", "Djati1234"));
        for (Customer customer : DatabaseCustomer.getCustomerDatabase()) {
            System.out.println(customer + "\n");
        }
        DatabaseFood.addFood(new Food(DatabaseFood.getLastId() + 1, "Vit-C", DatabaseSeller.getSellerById(1), 50000,
                FoodCategory.Snacks));
        DatabaseFood.addFood(new Food(DatabaseFood.getLastId() + 1, "Vit-A", DatabaseSeller.getSellerById(1), 20000,
                FoodCategory.Snacks));
        DatabaseFood.addFood(new Food(DatabaseFood.getLastId() + 1, "Mineral Water", DatabaseSeller.getSellerById(1), 4000,
                FoodCategory.Coffee));
        for (Food food : DatabaseFood.getFoodByCategory(FoodCategory.Snacks)) {
            System.out.println(food + "\n");
        }
        for (Food food : DatabaseFood.getFoodByCategory(FoodCategory.Coffee)) {
            System.out.println(food + "\n");
        }
    }
}
