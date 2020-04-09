import java.util.ArrayList;

/**
 * Write a description of class DatabaseCustomer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DatabaseCustomer {
    // instance variables - replace the example below with your own
    private static ArrayList<Customer> CUSTOMER_DATABASE = new ArrayList<Customer>();
    private static int lastId = 0;

    /**
     * Constructor for objects of class DatabaseCustomer
     */
    public DatabaseCustomer() {

    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @return the sum of x and y
     */
    public static boolean addCustomer(Customer customer) throws EmailAlreadyExistsException {
        for (Customer customers : CUSTOMER_DATABASE) {
            if (customers.getEmail().equals(customer.getEmail())) {
                    throw new EmailAlreadyExistsException(customer);
            }
        }
        CUSTOMER_DATABASE.add(customer);
        lastId = customer.getId();
        return true;
    }

    public static boolean removeCustomer(int id) throws CustomerNotFoundException {
        for (Customer customer : CUSTOMER_DATABASE) {
            if (customer.getId() == id) {
                CUSTOMER_DATABASE.remove(customer);
                return true;
            }
        }
            throw new CustomerNotFoundException(id);
    }

    public static ArrayList<Customer> getCustomerDatabase() {
        return CUSTOMER_DATABASE;
    }

    public static int getLastId() {
        return lastId;
    }

    public static Customer getCustomerById(int id) throws CustomerNotFoundException {
        for (Customer customer : CUSTOMER_DATABASE) {
            if (customer.getId() == id) {
                return customer;
            }
        }
            throw new CustomerNotFoundException(id);
    }
}
