package mustofakamal.jfood.database.postgre;

import mustofakamal.jfood.structure.model.Customer;
import mustofakamal.jfood.exception.CustomerNotFoundException;
import mustofakamal.jfood.exception.EmailAlreadyExistsException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DatabaseCustomerPostgre {
    public static boolean insertCustomer(Customer customer) throws EmailAlreadyExistsException {
        Connection c = null;
        Statement stmt = null;

        c = DatabaseConnectionPostgre.connection();

        try {
            stmt = c.createStatement();
            String sql = "INSERT INTO customer(id, name, email, password) " +
                    "VALUES(" + customer.getId() + ",'" + customer.getName() + "','" + customer.getEmail() + "','"
                    + customer.getPassword() + "');";
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

    public static int getLastCustomerId(){
        Connection c = null;
        Statement stmt = null;
        int id = 0;

        c = DatabaseConnectionPostgre.connection();

        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT MAX(id) AS last_id FROM customer;");
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

    public static Customer getCustomer(int id) throws CustomerNotFoundException {
        Connection c = null;
        Statement stmt = null;
        Customer customer = null;

        c = DatabaseConnectionPostgre.connection();

        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM customer WHERE id = " + id + ";");
            while (rs.next()){
                id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String password = rs.getString("password");
                Date joinDate = rs.getDate("joinDate");
                Calendar calendar = new GregorianCalendar();
                calendar.setTime(joinDate);
                customer = new Customer(id, name, email, password, calendar);
            }
            rs.close();
            stmt.close();
            c.close();
        }catch (Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Select customer successfully");
        return customer;
    }

    public static boolean removeCustomer(int id) throws CustomerNotFoundException{
        Connection c = null;
        Statement stmt = null;

        c = DatabaseConnectionPostgre.connection();

        try {
            stmt = c.createStatement();
            String sql = "DELETE FROM customer WHERE id = " + id + ";";
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Remove customer successfully");
        return true;
    }

    public static ArrayList<Customer> getCustomerDatabase() throws CustomerNotFoundException{
        ArrayList<Customer> customers = new ArrayList<>();

        Connection c = null;
        Statement stmt = null;
        int id;

        c = DatabaseConnectionPostgre.connection();

        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM customer;");
            while (rs.next()){
                id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String password = rs.getString("password");
                Date joinDate = rs.getDate("joinDate");
                Calendar calendar = new GregorianCalendar();
                calendar.setTime(joinDate);
                customers.add(new Customer(id, name, email, password, calendar));
            }
            rs.close();
            stmt.close();
            c.close();
        }catch (Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Select customer database successfully");
        return customers;
    }

    public static Customer customerLogin(String email, String password) {
        Connection c = null;
        Statement stmt = null;
        Customer customer = null;

        c = DatabaseConnectionPostgre.connection();

        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM customer WHERE email = '" + email + "' AND password = '" + password + "';");
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Date joinDate = rs.getDate("joinDate");
                Calendar calendar = new GregorianCalendar();
                calendar.setTime(joinDate);
                customer = new Customer(id, name, email, password, calendar);
            }
            rs.close();
            stmt.close();
            c.close();
        }catch (Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Select customer by email and password successfully");
        return customer;
    }
}
