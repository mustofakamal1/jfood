package mustofakamal.jfood.database.arraylist;
import mustofakamal.jfood.structure.model.Promo;
import mustofakamal.jfood.exception.PromoCodeAlreadyExistsException;
import mustofakamal.jfood.exception.PromoNotFoundExecption;

import java.util.ArrayList;

/**
 * Class DatabaseCustomer adalah class yang memproses
 * kumpulan data seluruh objek promo.
 *
 * @author Mustofa Kamal
 * @version 07-06-2020
 *
 * @deprecated beralih ke database postgre
 * @see mustofakamal.jfood.database.postgre.DatabasePromoPostgre
 */
@Deprecated
public class DatabasePromo {
    // instance variables - replace the example below with your own
    private static ArrayList<Promo> PROMO_DATABASE = new ArrayList<>();
    private static int lastId = 0;

    /**
     * Constructor for objects of class DatabasePromo
     */
    public DatabasePromo() {

    }

    public static ArrayList<Promo> getPromoDatabase() {
        return PROMO_DATABASE;
    }

    public static int getLastId() {
        return lastId;
    }

    public static Promo getPromoById(int id) throws PromoNotFoundExecption {
        for (Promo promo : PROMO_DATABASE) {
            if (promo.getId() == id) {
                return promo;
            }
        }
            throw new PromoNotFoundExecption(id);
    }

    public static Promo getPromoByCode(String code) {
        for (Promo promo : PROMO_DATABASE) {
            if (promo.getCode().equals(code)) {
                return promo;
            }
        }
        return null;
    }

    public static boolean addPromo(Promo promo) throws PromoCodeAlreadyExistsException {
        for (Promo promos : PROMO_DATABASE) {
            if (promos.getCode().equals(promo.getCode())) {
                    throw new PromoCodeAlreadyExistsException(promo);
            }
        }
        PROMO_DATABASE.add(promo);
        lastId = promo.getId();
        return true;
    }

    public static boolean removePromo(int id) throws PromoNotFoundExecption {
        for (Promo promo : PROMO_DATABASE) {
            if (promo.getId() == id) {
                PROMO_DATABASE.remove(promo);
                return true;
            }
        }
            throw new PromoNotFoundExecption(id);
    }

    public static boolean activatePromo(int id) {
        for (Promo promo : PROMO_DATABASE) {
            if (promo.getId() == id) {
                promo.setActive(true);
                PROMO_DATABASE.set(PROMO_DATABASE.indexOf(promo), promo);
                return true;
            }
        }
        return false;
    }

    public static boolean deactivatePromo(int id) {
        for (Promo promo : PROMO_DATABASE) {
            if (promo.getId() == id) {
                promo.setActive(false);
                PROMO_DATABASE.set(PROMO_DATABASE.indexOf(promo), promo);
                return true;
            }
        }
        return false;
    }
}
