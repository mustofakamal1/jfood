package mustofakamal.jfood.controller;

import mustofakamal.jfood.database.postgre.DatabaseCustomerPostgre;
import mustofakamal.jfood.exception.CustomerNotFoundException;
import mustofakamal.jfood.exception.EmailAlreadyExistsException;
import mustofakamal.jfood.structure.model.Customer;
import org.springframework.web.bind.annotation.*;

/**
 * Class SellerController adalah class yang berfungsi
 * menyediakan REST API untuk CRUD data objek customer.
 *
 * @author Mustofa Kamal
 * @version 07-06-2020
 */
@RequestMapping("/customer")
@RestController
public class CustomerController {

    @RequestMapping("")
    public String indexPage(@RequestParam(value="name", defaultValue="world") String name) {
        return "Hello " + name;
    }

    @RequestMapping("/{id}")
    public Customer getCustomerById(@PathVariable int id) {
        try {
            Customer customer = DatabaseCustomerPostgre.getCustomer(id);
            return customer;
        } catch (CustomerNotFoundException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Customer registerCustomer(@RequestParam(value="name") String name,
                                @RequestParam(value="email") String email,
                                @RequestParam(value="password") String password)
    {
        Customer customer = new Customer(DatabaseCustomerPostgre.getLastCustomerId()+1, name, email, password);
        try {
            DatabaseCustomerPostgre.insertCustomer(customer);
        } catch (EmailAlreadyExistsException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return customer;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Customer loginCustomer(
                                     @RequestParam(value="email") String email,
                                     @RequestParam(value="password") String password)
    {

        Customer customer = DatabaseCustomerPostgre.customerLogin(email, password);
        if(customer == null) {
            return null;
        }
        return customer;
    }
}
