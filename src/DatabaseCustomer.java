import java.util.ArrayList;

/**
 * Write a description of class DatabaseCustomer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DatabaseCustomer
{
    // instance variables - replace the example below with your own
    private static ArrayList<Customer> CUSTOMER_DATABASE;
    private static int lastId;
    /**
     * Constructor for objects of class DatabaseCustomer
     */
    public DatabaseCustomer()
    {
        CUSTOMER_DATABASE = new ArrayList<Customer>();
        lastId = 0;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @return    the sum of x and y
     */
    public static boolean addCustomer(Customer customer)
    {
        for(Customer customers : CUSTOMER_DATABASE) {
            if(customers.getEmail() == customer.getEmail()) {
                return false;
            }
        }
        CUSTOMER_DATABASE.add(customer);
        lastId = customer.getId();
        return true;
    }
    
    public static boolean removeCustomer(int id)
    {
        for(Customer customer : CUSTOMER_DATABASE) {
            if(customer.getId() == id) {
                CUSTOMER_DATABASE.remove(customer);
                return true;
            }
        }
        return false;
    }

    public static ArrayList<Customer> getCustomerDatabase()
    {
        return CUSTOMER_DATABASE;
    }

    public static int getLastId() {
        return lastId;
    }

    public static Customer getCustomerById(int id) {
        for(Customer customer : CUSTOMER_DATABASE) {
            if(customer.getId() == id) {
                return customer;
            }
        }
        return null;
    }
}
