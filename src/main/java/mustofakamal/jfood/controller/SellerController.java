package mustofakamal.jfood.controller;

        import mustofakamal.jfood.*;
        import org.springframework.web.bind.annotation.*;

        import java.util.ArrayList;

@RequestMapping("/seller")
@RestController
public class SellerController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ArrayList<Seller> getAllSeller() {
        return DatabaseSeller.getSellerDatabase();
    }

    @RequestMapping("/{id}")
    public Seller getSellerById(@PathVariable int id) {
        try {
            Seller seller = DatabaseSeller.getSellerById(id);
            return seller;
        } catch (SellerNotFoundException e) {
            e.getMessage();
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
            Seller seller = new Seller(DatabaseSeller.getLastId()+1, name, email, phoneNumber,
                    new Location(city, provinces,description));
            DatabaseSeller.addSeller(seller);
            return seller;
    }
}
