package mustofakamal.jfood.exception;

import mustofakamal.jfood.structure.model.Customer;

/**
 * Class EmailAlreadyExistsException adalah class yang berfungsi
 * memberikan peringatan ketika email sudah terdapat pada sistem.
 *
 * @author Mustofa Kamal
 * @version 07-06-2020
 */
public class EmailAlreadyExistsException extends Exception {

    private Customer customer_error;

    public EmailAlreadyExistsException (Customer customer_input) {
        super("Customer Email: ");
        this.customer_error = customer_input;
    }

    public String getMessage() {
        return super.getMessage() + customer_error.getEmail() + " already exists.";
    }
}
