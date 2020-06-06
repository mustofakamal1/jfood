package mustofakamal.jfood;
import mustofakamal.jfood.database.arraylist.DatabaseCustomer;
import mustofakamal.jfood.database.arraylist.DatabaseFood;
import mustofakamal.jfood.database.arraylist.DatabaseInvoice;
import mustofakamal.jfood.database.arraylist.DatabaseSeller;
import mustofakamal.jfood.database.postgre.*;
import mustofakamal.jfood.exception.CustomerNotFoundException;
import mustofakamal.jfood.exception.EmailAlreadyExistsException;
import mustofakamal.jfood.exception.OngoingInvoiceAlreadyExistsException;
import mustofakamal.jfood.exception.SellerNotFoundException;
import mustofakamal.jfood.structure.model.*;
import mustofakamal.jfood.structure.type.FoodCategory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JFood {

    public static void main(String[] args) {
        SpringApplication.run(JFood.class, args);
//        Seller seller1 = new Seller(DatabaseSeller.getLastId() + 1, "Rafid", "rafid@gmail.com",
//                "0812345678", new Location(DatabaseLocationPostgre.getLastLocationId() + 1, "Bekasi", "Jawa Barat", "Jauh"));
//        DatabaseSellerPostgre.insertSeller(seller1);
//        DatabaseLocationPostgre.insertLocation(new Location(DatabaseLocationPostgre.getLastLocationId() + 1, "Bekasi", "Jawa Barat", "Jauh"));

//        Food food1 = new Food(DatabaseFoodPostgre.getLastFoodId() + 1, "food1", seller1, 10000, FoodCategory.Bakery);
//        DatabaseFood.addFood(food1);
//        Food food2 = new Food(DatabaseFoodPostgre.getLastFoodId() + 1, "food2", seller1, 20000, FoodCategory.Coffee);
//        DatabaseFood.addFood(food2);
////        DatabaseFoodPostgre.insertFood(food2);
//        Customer customer1 = new Customer(DatabaseCustomer.getLastId() + 1, "User", "user@gmail.com", "User1234");
////        Customer customer2 = new Customer(DatabaseCustomerPostgre.getLastCustomerId() + 1, "Mustofa", "mustofa@gmail.com", "Qwer1234");
//        DatabaseSellerPostgre.insertSeller(new Seller(DatabaseSellerPostgre.getLastSellerId()+1, "Sel3",
//                "sel3@gmail.com", "081808180818", DatabaseLocationPostgre.getLocation(1)));
//        DatabaseSellerPostgre.insertSeller(new Seller(DatabaseSellerPostgre.getLastSellerId()+1, "Sel4",
//                "sel4@gmail.com", "081808180818", DatabaseLocationPostgre.getLocation(1)));
//        DatabaseSellerPostgre.insertSeller(new Seller(DatabaseSellerPostgre.getLastSellerId()+1, "Sel5",
//                "sel5@gmail.com", "081808180818", DatabaseLocationPostgre.getLocation(1)));
//        DatabaseSellerPostgre.insertSeller(new Seller(DatabaseSellerPostgre.getLastSellerId()+1, "Sel6",
//                "sel6@gmail.com", "081808180818", DatabaseLocationPostgre.getLocation(1)));
//        DatabaseSellerPostgre.insertSeller(new Seller(DatabaseSellerPostgre.getLastSellerId()+1, "Sel7",
//                "sel7@gmail.com", "081808180818", DatabaseLocationPostgre.getLocation(1)));
//        DatabaseSellerPostgre.insertSeller(new Seller(DatabaseSellerPostgre.getLastSellerId()+1, "Sel7",
//                "sel8@gmail.com", "081808180818", DatabaseLocationPostgre.getLocation(1)));
//        int i = 2;
//        for(i = 2; i < 8; i++) {
//            try {
//                DatabaseFoodPostgre.insertFood(new Food(DatabaseFoodPostgre.getLastFoodId() + 1,
//                        "food" + String.valueOf(i), DatabaseSellerPostgre.getSeller(i), 2300 * i, FoodCategory.Bakery));
//            } catch (SellerNotFoundException e) {
//                e.getMessage();
//            }
//        }
//
//        try {
//            DatabaseCustomer.addCustomer(customer1);
//        } catch (EmailAlreadyExistsException e) {
//            e.getMessage();
//        }

//        Promo promo1 = new Promo(DatabasePromo.getLastId() + 1, "firstBuy", 5000, 10000, true);
//        try {
////            DatabasePromoPostgre.removePromo(1);
//            DatabasePromoPostgre.insertPromo(promo1);
//        } catch ( PromoCodeAlreadyExistsException e) {
//            e.getMessage();
//        }

//        try {
//            CashlessInvoice invoice = new CashlessInvoice(DatabaseInvoicePostgre.getLastInvoiceId() + 1, DatabaseFoodPostgre.getFoodDatabase()
//                    , DatabaseCustomerPostgre.getCustomer(2), DatabasePromoPostgre.getPromoByCode("firstBuy"));
//            DatabaseInvoicePostgre.insertCashlessInvoice(invoice);
//        } catch (CustomerNotFoundException | OngoingInvoiceAlreadyExistsException e) {
//            System.out.println(e.getMessage());
//        }

//        try {
//            CashlessInvoice invoice = new CashlessInvoice(DatabaseInvoice.getLastId() + 1, DatabaseFoodPostgre.getFoodDatabase()
//                    , DatabaseCustomer.getCustomerById(1), DatabasePromoPostgre.getPromoByCode("firstBuy"));
//            DatabaseInvoice.addInvoice(invoice);
//        } catch (CustomerNotFoundException | OngoingInvoiceAlreadyExistsException e) {
//            System.out.println(e.getMessage());
//        }
//        try {
//            for(Invoice f : DatabaseInvoicePostgre.getInvoiceByCustomer(2)) {
//                System.out.println(f.getFoods());
//            }
//        } catch(Exception e) {
//            e.getMessage();
//        }
//        try {
//            DatabaseCustomerPostgre.insertCustomer(customer2);
//        } catch(EmailAlreadyExistsException e) {
//            e.getMessage();
//        }
//        for(Invoice f: DatabaseInvoicePostgre.getInvoiceByCustomer(3)){
//            System.out.println(f);
//        }
//        System.out.println(DatabaseInvoicePostgre.checkOnGoing(1));
//                System.out.println(DatabaseInvoicePostgre.getInvoiceByCustomer(3));
    }
}

