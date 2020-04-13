import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

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
//        DatabaseSeller.addSeller(new Seller(DatabaseSeller.getLastId() + 1, "Mulya",
//                "mulya@gmail.com", "0812345678", loc6));
//        DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId() + 1, "Mustofa Kamal",
//                "mustofa.kamal71@ui.ac.id", "pFss1234"));
//        DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId() + 1, "Mustofa Kamal",
//                "mustofa.kamal71@ui.ac.id", "pSass1434"));
//        DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId() + 1, "Djati Pradana",
//                "djati.pradana@ui.ac.id", "Djati1234"));
//        for (Customer customer : DatabaseCustomer.getCustomerDatabase()) {
//            System.out.println(customer + "\n");
//        }
//        DatabaseFood.addFood(new Food(DatabaseFood.getLastId() + 1, "Vit-C", DatabaseSeller.getSellerById(1), 50000,
//                FoodCategory.Snacks));
//        DatabaseFood.addFood(new Food(DatabaseFood.getLastId() + 1, "Vit-A", DatabaseSeller.getSellerById(1), 20000,
//                FoodCategory.Snacks));
//        DatabaseFood.addFood(new Food(DatabaseFood.getLastId() + 1, "Mineral Water", DatabaseSeller.getSellerById(1), 4000,
//                FoodCategory.Coffee));
//        for (Food food : DatabaseFood.getFoodByCategory(FoodCategory.Snacks)) {
//            System.out.println(food + "\n");
//        }
//        for (Food food : DatabaseFood.getFoodByCategory(FoodCategory.Coffee)) {
//            System.out.println(food + "\n");
//        }

        //Post Test Modul 6
//        DatabasePromo.addPromo(new Promo(DatabasePromo.getLastId()+1, "ABCSD", 3000, 10000, false));
//        DatabasePromo.addPromo(new Promo(DatabasePromo.getLastId()+1, "ABCSD", 1000, 1000, true));
//        for (Promo promo : DatabasePromo.getPromoDatabase()) {
//            System.out.println(promo + "\n");
//        }
//        ArrayList<Food> food1 = new ArrayList<>(Collections.singletonList(DatabaseFood.getFoodById(1)));
//        ArrayList<Food> food2 = new ArrayList<>(Collections.singletonList(DatabaseFood.getFoodById(2)));
//        DatabaseInvoice.addInvoice(new CashInvoice(DatabaseInvoice.getLastId()+1, food1, DatabaseCustomer.getCustomerById(1), 1000));
//        for(Invoice invoice : DatabaseInvoice.getInvoiceByCustomer(1)){
//            invoice.setTotalPrice();
//            DatabaseInvoice.getInvoiceDatabase().set(DatabaseInvoice.getInvoiceDatabase().indexOf(invoice), invoice);
//        }
//
//        DatabaseInvoice.addInvoice(new CashlessInvoice(DatabaseInvoice.getLastId()+1, food1, DatabaseCustomer.getCustomerById(1), DatabasePromo.getPromoById(0)));
//        for(Invoice invoice : DatabaseInvoice.getInvoiceByCustomer(1)){
//            invoice.setTotalPrice();
//            DatabaseInvoice.getInvoiceDatabase().set(DatabaseInvoice.getInvoiceDatabase().indexOf(invoice), invoice);
//        }
//
//        for (Invoice invoice : DatabaseInvoice.getInvoiceDatabase()) {
//            System.out.println(invoice + "\n");
//        }
//        DatabaseInvoice.changeInvoiceStatus( DatabaseInvoice.getInvoiceDatabase(1).indexOf(DatabaseInvoice.getInvoiceByCustomer(1)), InvoiceStatus.Finished);

        //Modul 7
        //Exception
        try {
            DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId() + 1, "Mustofa Kamal",
                    "mustofa.kamal71@ui.ac.id", "pFss1234"));
        } catch (EmailAlreadyExistsException exp) {
            System.out.println(exp.getMessage());
        }
//
//        try {
//            DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId() + 1, "Mustofa",
//                    "mustofa.kamal71@ui.ac.id", "pSass1434"));
//        } catch (EmailAlreadyExistsException exp) {
//            System.out.println(exp.getMessage());
//        }
//
//        try {
//            DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId() + 1, "Djati Pradana",
//                    "djati.pradana@ui.ac.id", "Djati1234"));
//        } catch (EmailAlreadyExistsException exp) {
//            System.out.println(exp.getMessage());
//        }
//
//        try {
//            DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId() + 1, "Djati",
//                    "djati@ui.ac.id", "Djati1234"));
//        } catch (EmailAlreadyExistsException exp) {
//            System.out.println(exp.getMessage());
//        }
//
//        try {
//            DatabasePromo.addPromo(new Promo(DatabasePromo.getLastId()+1, "ABCSD", 3000, 10000,
//                    true));
//        } catch (PromoCodeAlreadyExistsException exp) {
//            System.out.println(exp.getMessage());
//        }
//
//        try {
//            DatabasePromo.addPromo(new Promo(DatabasePromo.getLastId()+1, "ABCSD", 1000, 1000,
//                    true));
//        } catch (PromoCodeAlreadyExistsException exp) {
//            System.out.println(exp.getMessage());
//        }
//
//        DatabaseFood.addFood(new Food(DatabaseFood.getLastId() + 1, "Vit-C", new Seller(DatabaseSeller.getLastId() + 1, "Mulya",
//                "mulya@gmail.com", "0812345678", loc6 ), 50000, FoodCategory.Snacks));
//
//        try {
//            DatabaseFood.addFood(new Food(DatabaseFood.getLastId() + 1, "Vit-A", DatabaseSeller.getSellerById(3),
//                    20000, FoodCategory.Snacks));
//        } catch (SellerNotFoundException exp) {
//            System.out.println(exp.getMessage());
//        }
//
//        try {
//            DatabaseFood.getFoodById(10);
//        } catch (FoodNotFoundException exp) {
//            System.out.println(exp.getMessage());
//        }
//
//        try {
//            DatabaseCustomer.getCustomerById(10);
//        } catch (CustomerNotFoundException exp) {
//            System.out.println(exp.getMessage());
//        }
//
//        try {
//            DatabasePromo.removePromo(10);
//        } catch (PromoNotFoundExecption exp) {
//            System.out.println(exp.getMessage());
//        }
//        System.out.println("\n=====================Data Berhasil Masuk Database=====================");
//        for (Promo promo : DatabasePromo.getPromoDatabase()) {
//            System.out.println(promo + "\n");
//        }
//
//        for (Customer customer : DatabaseCustomer.getCustomerDatabase()) {
//            System.out.println(customer + "\n");
//        }
//
//        for (Food food : DatabaseFood.getFoodDatabase()) {
//            System.out.println(food + "\n");
//        }
//
//        //Thread
//        System.out.println("\n=====================Multithreading=====================");
//        try {
//            Invoice invoice1 = new CashInvoice(DatabaseInvoice.getLastId() + 1, DatabaseFood.getFoodDatabase(),
//                    DatabaseCustomer.getCustomerById(1), 1000);
//            DatabaseInvoice.addInvoice(invoice1);
//        } catch (CustomerNotFoundException exp) {
//            System.out.println(exp.getMessage());
//        }
//
//        try {
//        Invoice invoice2 = new CashInvoice(DatabaseInvoice.getLastId()+1, DatabaseFood.getFoodDatabase(),
//                DatabaseCustomer.getCustomerById(2), 2000);
//            DatabaseInvoice.addInvoice(invoice2);
//        } catch (CustomerNotFoundException exp) {
//            System.out.println(exp.getMessage());
//        }
//
//        try {
//        Invoice invoice3 = new CashInvoice(DatabaseInvoice.getLastId()+1, DatabaseFood.getFoodDatabase(),
//                DatabaseCustomer.getCustomerById(3), 3000);
//            DatabaseInvoice.addInvoice(invoice3);
//        } catch (CustomerNotFoundException exp) {
//            System.out.println(exp.getMessage());
//        }
//
//        for(Invoice invoice : DatabaseInvoice.getInvoiceDatabase()) {
//            PriceCalculator p1 = new PriceCalculator(invoice);
//            p1.start();
//        }

        //Post Test Modul 7
        try {
            Invoice invoice1 = new CashInvoice(DatabaseInvoice.getLastId() + 1, DatabaseFood.getFoodDatabase(),
                    DatabaseCustomer.getCustomerById(1), 1000);
            DatabaseInvoice.addInvoice(invoice1);
        } catch (CustomerNotFoundException exp) {
            System.out.println(exp.getMessage());
        } catch (OngoingInvoiceAlreadyExistsException exp2) {
            System.out.println(exp2.getMessage());
        }

        try {
            Invoice invoice2 = new CashInvoice(DatabaseInvoice.getLastId()+1, DatabaseFood.getFoodDatabase(),
                    DatabaseCustomer.getCustomerById(1), 2000);
            DatabaseInvoice.addInvoice(invoice2);
        } catch (CustomerNotFoundException exp) {
            System.out.println(exp.getMessage());
        } catch (OngoingInvoiceAlreadyExistsException exp2) {
            System.out.println(exp2.getMessage());
        }

        try {
            DatabaseInvoice.removeInvoice(100);
        } catch (InvoiceNotFoundException exp) {
            System.out.println(exp.getMessage());
        }

        try {
            DatabaseInvoice.getInvoiceById(100);
        } catch (InvoiceNotFoundException exp) {
            System.out.println(exp.getMessage());
        }

        System.out.println("\n=====================Data Berhasil Masuk Database=====================");
        for (Customer customer : DatabaseCustomer.getCustomerDatabase()) {
            System.out.println(customer + "\n");
        }

        for (Invoice invoice : DatabaseInvoice.getInvoiceDatabase()) {
            System.out.println(invoice + "\n");
        }
    }
}
