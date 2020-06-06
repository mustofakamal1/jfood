package mustofakamal.jfood.exception;

/**
 * Class FoodNotFoundException adalah class yang berfungsi
 * memberikan peringatan food tidak ditemukan.
 *
 * @author Mustofa Kamal
 * @version 07-06-2020
 */
public class FoodNotFoundException extends Exception {

    private int food_error;

    public FoodNotFoundException (int food_input) {
        super("Food ID: ");
        this.food_error = food_input;
    }

    public String getMessage() {
        return super.getMessage() + food_error + " not found";
    }
}
