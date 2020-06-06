package mustofakamal.jfood.controller;

import mustofakamal.jfood.database.postgre.DatabaseFoodPostgre;
import mustofakamal.jfood.database.postgre.DatabaseSellerPostgre;
import mustofakamal.jfood.exception.FoodNotFoundException;
import mustofakamal.jfood.exception.SellerNotFoundException;
import mustofakamal.jfood.structure.model.Food;
import mustofakamal.jfood.structure.type.FoodCategory;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * Class SellerController adalah class yang berfungsi
 * menyediakan REST API untuk CRUD data objek food.
 *
 * @author Mustofa Kamal
 * @version 07-06-2020
 */
@RequestMapping("/food")
@RestController
public class FoodController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ArrayList<Food> getAllFood() {
        return DatabaseFoodPostgre.getFoodDatabase();
    }

    @RequestMapping("/{id}")
    public Food getFoodById(@PathVariable int id) {
        try {
            Food food = DatabaseFoodPostgre.getFood(id);
            return food;
        } catch (FoodNotFoundException e) {
            e.getMessage();
            return null;
        }
    }

    @RequestMapping("/seller/{sellerId}")
    public ArrayList<Food> getFoodBySeller(@PathVariable int sellerId) {
        return DatabaseFoodPostgre.getFoodBySeller(sellerId);
    }

    @RequestMapping("/category/{category}")
    public ArrayList<Food> getFoodByCategory(@PathVariable FoodCategory category) {
        return DatabaseFoodPostgre.getFoodByCategory(category);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Food addFood(@RequestParam(value="name") String name,
                                     @RequestParam(value="price") int price,
                                     @RequestParam(value="category") FoodCategory category,
                                     @RequestParam(value="sellerId") int sellerId)
    {
        try {
            Food food = new Food(DatabaseFoodPostgre.getLastFoodId()+1, name, DatabaseSellerPostgre.
                    getSeller(sellerId), price, category);
            DatabaseFoodPostgre.insertFood(food);
            return food;
        } catch (SellerNotFoundException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
