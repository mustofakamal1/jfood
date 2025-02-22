package mustofakamal.jfood.exception;

/**
 * Class CustomerNotFoundException adalah class yang berfungsi
 * memberikan peringatan customer tidak ditemukan.
 *
 * @author Mustofa Kamal
 * @version 07-06-2020
 */
public class CustomerNotFoundException extends Exception {

    private int customer_error;

    public CustomerNotFoundException (int customer_input) {
        super("Customer ID: ");
        this.customer_error = customer_input;
    }

    public String getMessage() {
        return super.getMessage() + customer_error + " not found";
    }
}
