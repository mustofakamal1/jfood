package mustofakamal.jfood.controller;

import mustofakamal.jfood.*;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RequestMapping("/invoice")
@RestController
public class InvoiceController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ArrayList<Invoice> getAllInvoice() {
        return DatabaseInvoice.getInvoiceDatabase();
    }

    @RequestMapping("/{id}")
    public Invoice getInvoiceById(@PathVariable int id) {
        try {
            return DatabaseInvoice.getInvoiceById(id);
        } catch (InvoiceNotFoundException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @RequestMapping("/customer/{customerId}")
    public ArrayList<Invoice> getInvoiceByCustomer(@PathVariable int customerId) {
        return DatabaseInvoice.getInvoiceByCustomer(customerId);
    }

    @RequestMapping(value = "/invoiceStatus/{id}", method = RequestMethod.PUT)
    public Invoice changeInvoiceStatus(@PathVariable int id,
                                       @RequestParam(value = "invoiceStatus") InvoiceStatus status)
    {
        boolean cek = DatabaseInvoice.changeInvoiceStatus(id, status);
        if(cek) {
            try {
                return DatabaseInvoice.getInvoiceById(id);
            } catch (InvoiceNotFoundException e) {
                System.out.println(e.getMessage());
                return null;
            }
        }
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public boolean removeInvoice(@PathVariable int id) {
        try {
            return DatabaseInvoice.removeInvoice(id);
        } catch (InvoiceNotFoundException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @RequestMapping(value = "/createCashInvoice", method = RequestMethod.POST)
    public Invoice addCashInvoice(
                        @RequestParam(value="foodIdList") ArrayList<Integer> foodIdList,
                        @RequestParam(value="customerId") int customerId,
                        @RequestParam(value="deliveryFee") int deliveryFee)
    {
        ArrayList<Food> foods = new ArrayList<>();
        for (int food : foodIdList) {
            try {
                foods.add(DatabaseFood.getFoodById(food));
            } catch (FoodNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
        try {
            Invoice invoice = new CashInvoice(DatabaseInvoice.getLastId()+1, foods,
                    DatabaseCustomer.getCustomerById(customerId), deliveryFee);
            DatabaseInvoice.addInvoice(invoice);
            return invoice;
        } catch (CustomerNotFoundException | OngoingInvoiceAlreadyExistsException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @RequestMapping(value = "/createCashlessInvoice", method = RequestMethod.POST)
    public Invoice addCashlessInvoice(
                                  @RequestParam(value="foodIdList") ArrayList<Integer> foodIdList,
                                  @RequestParam(value="customerId") int customerId,
                                  @RequestParam(value="promoCode") String promoCode)
    {
        ArrayList<Food> foods = new ArrayList<>();
        for (int food : foodIdList) {
            try {
                foods.add(DatabaseFood.getFoodById(food));
            } catch (FoodNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
        try {
            Invoice invoice = new CashlessInvoice(DatabaseInvoice.getLastId()+1, foods,
                    DatabaseCustomer.getCustomerById(customerId), DatabasePromo.getPromoByCode(promoCode));
            DatabaseInvoice.addInvoice(invoice);
            return invoice;
        } catch (CustomerNotFoundException | OngoingInvoiceAlreadyExistsException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
