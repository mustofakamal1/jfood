package mustofakamal.jfood.controller;

import mustofakamal.jfood.*;
import org.springframework.web.bind.annotation.*;

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
            Customer customer = DatabaseCustomer.getCustomerById(id);
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
        Customer customer = new Customer(DatabaseCustomer.getLastId()+1, name, email, password);
        try {
            DatabaseCustomer.addCustomer(customer);
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

        Customer customer = DatabaseCustomer.customerLogin(email, password);
        if(customer == null) {
            return null;
        }
        return customer;
    }
}
