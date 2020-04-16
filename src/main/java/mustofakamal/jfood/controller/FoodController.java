package mustofakamal.jfood.controller;

import mustofakamal.jfood.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequestMapping("/food")
@RestController
public class FoodController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ArrayList<Food> getAllFood() {
        return DatabaseFood.getFoodDatabase();
    }

    @RequestMapping("/{id}")
    public Food getFoodById(@PathVariable int id) {
        try {
            Food food = DatabaseFood.getFoodById(id);
            return food;
        } catch (FoodNotFoundException e) {
            e.getMessage();
            return null;
        }
    }

    @RequestMapping("/seller/{sellerId}")
    public ArrayList<Food> getFoodBySeller(@PathVariable int sellerId) {
        return DatabaseFood.getFoodBySeller(sellerId);
    }

    @RequestMapping("/category/{category}")
    public ArrayList<Food> getFoodByCategory(@PathVariable FoodCategory category) {
        return DatabaseFood.getFoodByCategory(category);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Food addFood(@RequestParam(value="name") String name,
                                     @RequestParam(value="price") int price,
                                     @RequestParam(value="category") FoodCategory category,
                                     @RequestParam(value="sellerId") int sellerId)
    {
        try {
            Food food = new Food(DatabaseFood.getLastId()+1, name, DatabaseSeller.getSellerById(sellerId),
                    price, category);
            DatabaseFood.addFood(food);
            return food;
        } catch (SellerNotFoundException e) {
            e.getMessage();
            return null;
        }
    }
}
