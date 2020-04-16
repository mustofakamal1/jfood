package mustofakamal.jfood;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JFood {

    public static void main(String[] args) {
        Location loc1 = new Location("Jakarta Timur", "Jakarta", "Home");
        Location loc2 = new Location("Depok", "Jawa Barat", "UI");
        Location loc3 = new Location("Bekasi", "Jawa Barat", "Jauh");
        Seller seller1 = new Seller(DatabaseSeller.getLastId() + 1, "Rafid", "rafid@gmail.com",
                "0812345678", loc3);
        DatabaseSeller.addSeller(seller1);
        Seller seller2 = new Seller(DatabaseSeller.getLastId() + 1, "Mulya", "mulya@gmail.com",
                "0856781234", loc2);
        DatabaseSeller.addSeller(seller2);
        Seller seller3 = new Seller(DatabaseSeller.getLastId() + 1, "Ilham", "ilham@gmail.com",
                "0812783456", loc1);
        DatabaseSeller.addSeller(seller3);
        Food food1 = new Food(DatabaseFood.getLastId() + 1, "food1", seller1, 10000, FoodCategory.Bakery);
        DatabaseFood.addFood(food1);
        Food food2 = new Food(DatabaseFood.getLastId() + 1, "food2", seller2, 20000, FoodCategory.Coffee);
        DatabaseFood.addFood(food2);
        Food food3 = new Food(DatabaseFood.getLastId() + 1, "food3", seller3, 80000, FoodCategory.Japanese);
        DatabaseFood.addFood(food3);
        Food food4 = new Food(DatabaseFood.getLastId() + 1, "food4", seller1, 15000, FoodCategory.Bakery);
        DatabaseFood.addFood(food4);
        SpringApplication.run(JFood.class, args);
    }

}

