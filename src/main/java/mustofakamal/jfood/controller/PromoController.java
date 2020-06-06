package mustofakamal.jfood.controller;

import mustofakamal.jfood.database.postgre.DatabasePromoPostgre;
import mustofakamal.jfood.exception.PromoCodeAlreadyExistsException;
import mustofakamal.jfood.structure.model.Promo;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RequestMapping("/promo")
@RestController
public class PromoController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ArrayList<Promo> getAllPromo() {
        return DatabasePromoPostgre.getPromoDatabase();
    }

    @RequestMapping("/{code}")
    public Promo getPromoByCode(@PathVariable String code) {
        Promo promo = DatabasePromoPostgre.getPromoByCode(code);
        return promo;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Promo addPromo(@RequestParam(value="code") String code,
                            @RequestParam(value="discount") int discount,
                            @RequestParam(value="minPrice") int minPrice,
                            @RequestParam(value="active") boolean active)
    {
        Promo promo = new Promo(DatabasePromoPostgre.getLastPromoId()+1, code, discount, minPrice, active);
        try {
            DatabasePromoPostgre.insertPromo(promo);
            return promo;
        } catch (PromoCodeAlreadyExistsException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
