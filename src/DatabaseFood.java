import java.util.ArrayList;

/**
 * Seller adalah class yang berfungsi memproses informasi semua food di jFood.
 *
 * @author Mustofa Kamal
 * @version 28-02-2020
 */
public class DatabaseFood {
    // instance variables - replace the example below with your own
    private static ArrayList<Food> FOOD_DATABASE = new ArrayList<Food>();
    private static int lastId = 0;

    /**
     * Constructor for objects of class DatabaseFood.
     */
    public DatabaseFood() {

    }

    public static boolean addFood(Food food) {
        FOOD_DATABASE.add(food);
        lastId = food.getId();
        return true;
    }

    public static boolean removeFood(int id) throws FoodNotFoundException {
        for (Food food : FOOD_DATABASE) {
            if (food.getId() == id) {
                FOOD_DATABASE.remove(food);
                return true;
            }
        }
            throw new FoodNotFoundException(id);
    }

    public static ArrayList<Food> getFoodDatabase() {
        return FOOD_DATABASE;
    }

    public static int getLastId() {
        return lastId;
    }

    public static Food getFoodById(int id) throws FoodNotFoundException {
        for (Food food : FOOD_DATABASE) {
            if (food.getId() == id) {
                return food;
            }
        }
            throw new FoodNotFoundException(id);
    }

    public static ArrayList<Food> getFoodBySeller(int sellerId) {
        ArrayList<Food> foods = new ArrayList<Food>();
        for (Food food : FOOD_DATABASE) {
            if (food.getSeller().getId() == sellerId) {
                foods.add(food);
                return foods;
            }
        }
        return null;
    }

    public static ArrayList<Food> getFoodByCategory(FoodCategory category) {
        ArrayList<Food> foods = new ArrayList<>();
        for (Food food : FOOD_DATABASE) {
            if (food.getCategory().equals(category)) {
                foods.add(food);
            }
        }
        return foods;
    }


}
