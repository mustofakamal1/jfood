package mustofakamal.jfood.controller;

import mustofakamal.jfood.database.postgre.DatabaseLocationPostgre;
import mustofakamal.jfood.database.postgre.DatabaseSellerPostgre;
import mustofakamal.jfood.exception.SellerNotFoundException;
import mustofakamal.jfood.structure.model.Location;
import mustofakamal.jfood.structure.model.Seller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * Class SellerController adalah class yang berfungsi
 * menyediakan REST API untuk CRUD data objek seller.
 *
 * @author Mustofa Kamal
 * @version 07-06-2020
 */
@RequestMapping("/seller")
@RestController
public class SellerController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ArrayList<Seller> getAllSeller() {
        return DatabaseSellerPostgre.getSellerDatabase();
    }

    @RequestMapping("/{id}")
    public Seller getSellerById(@PathVariable int id) {
        try {
            Seller seller = DatabaseSellerPostgre.getSeller(id);
            return seller;
        } catch (SellerNotFoundException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Seller addSeller(@RequestParam(value="name") String name,
                          @RequestParam(value="email") String email,
                          @RequestParam(value="phoneNumber") String phoneNumber,
                          @RequestParam(value="province") String provinces,
                          @RequestParam(value="description") String description,
                          @RequestParam(value="city") String city)
    {
            Seller seller = new Seller(DatabaseSellerPostgre.getLastSellerId()+1, name, email, phoneNumber,
                    new Location(DatabaseLocationPostgre.getLastLocationId(), city, provinces,description));
            DatabaseSellerPostgre.insertSeller(seller);
            return seller;
    }
}
