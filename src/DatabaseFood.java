import jdk.jfr.Category;

import java.util.ArrayList;

/**
 * Seller adalah class yang berfungsi memproses informasi semua food di jFood.
 *
 * @author Mustofa Kamal
 * @version 28-02-2020
 */
public class DatabaseFood
{
    // instance variables - replace the example below with your own
    private static ArrayList<Food> FOOD_DATABASE;
    private static int lastId;

    /**
     * Constructor for objects of class DatabaseFood.
     */
    public DatabaseFood()
    {
        // initialise instance variables
        FOOD_DATABASE = new ArrayList<Food>();
        lastId = 0;
    }

    public static boolean addFood(Food food)
    {
        FOOD_DATABASE.add(food);
        lastId = food.getId();
        return true;
    }

    public static boolean removeFood(int id)
    {
        for(Food food : FOOD_DATABASE) {
            if(food.getId() == id) {
                FOOD_DATABASE.remove(food);
                return true;
            }
        }
        return false;
    }

    public static ArrayList<Food> getFoodDatabase()
    {
        return FOOD_DATABASE;
    }

    public static int getLastId() {
        return lastId;
    }

    public static Food getFoodById(int id) {
        for(Food food : FOOD_DATABASE) {
            if(food.getId() == id) {
                return food;
            }
        }
        return null;
    }

    public static ArrayList<Food> getFoodBySeller(int sellerId) {
        ArrayList<Food> foods = new ArrayList<Food>();
        for(Food food : FOOD_DATABASE) {
            if(food.getSeller().getId() == sellerId) {
                foods.add(food);
                return foods;
            }
        }
        return null;
    }

    public static ArrayList<Food> getFoodByCategory(FoodCategory category) {
        ArrayList<Food> foods = new ArrayList<Food>();
        for(Food food : FOOD_DATABASE) {
            if(food.getCategory() == category) {
                foods.add(food);
                return foods;
            }
        }
        return null;
    }


}
