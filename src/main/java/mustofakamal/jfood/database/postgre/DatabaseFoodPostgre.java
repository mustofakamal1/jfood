package mustofakamal.jfood.database.postgre;

import mustofakamal.jfood.database.arraylist.DatabaseSeller;
import mustofakamal.jfood.structure.model.Food;
import mustofakamal.jfood.structure.type.FoodCategory;
import mustofakamal.jfood.exception.FoodNotFoundException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DatabaseFoodPostgre {
    public static boolean insertFood(Food food) {
        Connection c = null;
        Statement stmt = null;

        c = DatabaseConnectionPostgre.connection();

        try {
            stmt = c.createStatement();
            String sql = "INSERT INTO food(id, name, seller, price, category) " +
                    "VALUES(" + food.getId() + ",'" + food.getName() + "'," + food.getSeller().getId() + ","
                    + food.getPrice() + ",'" + food.getCategory() + "');";
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
            System.out.println("Records created unsuccessfully");
            return false;
        }
        System.out.println("Records created successfully");
        return true;
    }

    public static int getLastFoodId(){
        Connection c = null;
        Statement stmt = null;
        int id = 0;

        c = DatabaseConnectionPostgre.connection();

        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT MAX(id) AS last_id FROM food;");
            while (rs.next()){
                id = rs.getInt("last_id");
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Select last id successfully");
        return id;
    }

    public static Food getFood(int id) throws FoodNotFoundException {
        Connection c = null;
        Statement stmt = null;
        Food food = null;

        c = DatabaseConnectionPostgre.connection();

        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM food WHERE id = " + id + ";");
            while (rs.next()){
                id = rs.getInt("id");
                String name = rs.getString("name");
                int seller = rs.getInt("seller");
                int price = rs.getInt("price");
                String category = rs.getString("category");
                food = new Food(id, name, DatabaseSellerPostgre.getSeller(seller), price, categoryToFoodCategory(category));
            }
            rs.close();
            stmt.close();
            c.close();
        }catch (Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Select food successfully");
        return food;
    }

    public static boolean removeFood(int id) throws FoodNotFoundException {
        Connection c = null;
        Statement stmt = null;

        c = DatabaseConnectionPostgre.connection();

        try {
            stmt = c.createStatement();
            String sql = "DELETE FROM food WHERE id = " + id + ";";
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Remove food successfully");
        return true;
    }

    public static ArrayList<Food> getFoodDatabase() {
        ArrayList<Food> foods = new ArrayList<>();

        Connection c = null;
        Statement stmt = null;
        int id;

        c = DatabaseConnectionPostgre.connection();

        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM food;");
            while (rs.next()){
                id = rs.getInt("id");
                String name = rs.getString("name");
                int seller = rs.getInt("seller");
                int price = rs.getInt("price");
                String category = rs.getString("category");
                foods.add(new Food(id, name, DatabaseSellerPostgre.getSeller(seller), price,
                        categoryToFoodCategory(category)));
            }
            rs.close();
            stmt.close();
            c.close();
        }catch (Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Select food database successfully");
        return foods;
    }

    public static ArrayList<Food> getFoodBySeller(int id) {
        ArrayList<Food> foods = new ArrayList<>();

        Connection c = null;
        Statement stmt = null;

        c = DatabaseConnectionPostgre.connection();

        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM food WHERE seller = " + id + ";");
            while (rs.next()){
                String name = rs.getString("name");
                int seller = rs.getInt("seller");
                int price = rs.getInt("price");
                String category = rs.getString("category");
                foods.add(new Food(id, name, DatabaseSellerPostgre.getSeller(seller), price,
                        categoryToFoodCategory(category)));
            }
            rs.close();
            stmt.close();
            c.close();
        }catch (Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Select food database successfully");
        return foods;
    }

    public static ArrayList<Food> getFoodByCategory(FoodCategory category) {
        ArrayList<Food> foods = new ArrayList<>();

        Connection c = null;
        Statement stmt = null;

        c = DatabaseConnectionPostgre.connection();

        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM food WHERE category = '" + category + "';");
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int seller = rs.getInt("seller");
                int price = rs.getInt("price");
                foods.add(new Food(id, name, DatabaseSellerPostgre.getSeller(seller), price, category));
            }
            rs.close();
            stmt.close();
            c.close();
        }catch (Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Select food database successfully");
        return foods;
    }

    private static FoodCategory categoryToFoodCategory(String cat) {
        FoodCategory category = null;
        switch (cat) {
            case "Beverages" :
                category = FoodCategory.Beverages;
                break;
            case "Coffee" :
                category = FoodCategory.Coffee;
                break;
            case "Western" :
                category = FoodCategory.Western;
                break;
            case "Snacks" :
                category = FoodCategory.Snacks;
                break;
            case "Rice" :
                category = FoodCategory.Rice;
                break;
            case "Noodles" :
                category = FoodCategory.Noodles;
                break;
            case "Bakery" :
                category = FoodCategory.Bakery;
                break;
            case "Japanese" :
                category = FoodCategory.Japanese;
                break;
            default:
                return null;
        }
        return category;
    }
}
