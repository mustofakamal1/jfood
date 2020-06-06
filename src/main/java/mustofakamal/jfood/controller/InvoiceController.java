package mustofakamal.jfood.controller;

import mustofakamal.jfood.database.postgre.DatabaseCustomerPostgre;
import mustofakamal.jfood.database.postgre.DatabaseFoodPostgre;
import mustofakamal.jfood.database.postgre.DatabaseInvoicePostgre;
import mustofakamal.jfood.database.postgre.DatabasePromoPostgre;
import mustofakamal.jfood.exception.CustomerNotFoundException;
import mustofakamal.jfood.exception.FoodNotFoundException;
import mustofakamal.jfood.exception.InvoiceNotFoundException;
import mustofakamal.jfood.exception.OngoingInvoiceAlreadyExistsException;
import mustofakamal.jfood.structure.model.CashInvoice;
import mustofakamal.jfood.structure.model.CashlessInvoice;
import mustofakamal.jfood.structure.model.Food;
import mustofakamal.jfood.structure.model.Invoice;
import mustofakamal.jfood.structure.type.InvoiceStatus;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RequestMapping("/invoice")
@RestController
public class InvoiceController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ArrayList<Invoice> getAllInvoice() {
        return DatabaseInvoicePostgre.getInvoiceDatabase();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Invoice getInvoiceById(@PathVariable int id) {
        try {
            return DatabaseInvoicePostgre.getInvoice(id);
        } catch (InvoiceNotFoundException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @RequestMapping(value = "/customer/{customerId}", method = RequestMethod.GET)
    public ArrayList<Invoice> getInvoiceByCustomer(@PathVariable int customerId) {
        return DatabaseInvoicePostgre.getInvoiceByCustomer(customerId);
    }

    @RequestMapping(value = "/invoiceStatus/{id}", method = RequestMethod.PUT)
    public Invoice changeInvoiceStatus(@PathVariable int id,
                                       @RequestParam(value = "invoiceStatus") InvoiceStatus status)
    {
        boolean cek = DatabaseInvoicePostgre.changeInvoiceStatus(id, status);
        if(cek) {
            try {
                return DatabaseInvoicePostgre.getInvoice(id);
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
            return DatabaseInvoicePostgre.removeInvoice(id);
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
                foods.add(DatabaseFoodPostgre.getFood(food));
            } catch (FoodNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
        try {
            CashInvoice invoice = new CashInvoice(DatabaseInvoicePostgre.getLastInvoiceId()+1, foods,
                    DatabaseCustomerPostgre.getCustomer(customerId), deliveryFee);
            invoice.setTotalPrice();
            DatabaseInvoicePostgre.insertCashInvoice(invoice);
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
        CashlessInvoice invoice;
        for (int food : foodIdList) {
            try {
                foods.add(DatabaseFoodPostgre.getFood(food));
            } catch (FoodNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
        try {
            invoice = new CashlessInvoice(DatabaseInvoicePostgre.getLastInvoiceId() + 1, foods,
                    DatabaseCustomerPostgre.getCustomer(customerId), DatabasePromoPostgre.getPromoByCode(promoCode));
            invoice.setTotalPrice();
            DatabaseInvoicePostgre.insertCashlessInvoice(invoice);
            return invoice;
        } catch (CustomerNotFoundException | OngoingInvoiceAlreadyExistsException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
