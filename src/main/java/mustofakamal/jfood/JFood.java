package mustofakamal.jfood;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JFood {

    public static void main(String[] args) {
        SpringApplication.run(JFood.class, args);
        Seller seller1 = new Seller(DatabaseSeller.getLastId() + 1, "Rafid", "rafid@gmail.com",
                "0812345678", new Location("Bekasi", "Jawa Barat", "Jauh"));
        DatabaseSeller.addSeller(seller1);
        Food food1 = new Food(DatabaseFood.getLastId() + 1, "food1", seller1, 10000, FoodCategory.Bakery);
        DatabaseFood.addFood(food1);
        Food food2 = new Food(DatabaseFood.getLastId() + 1, "food2", seller1, 20000, FoodCategory.Coffee);
        DatabaseFood.addFood(food2);
    }
}

