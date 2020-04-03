import java.util.ArrayList;

/**
 * Write a description of class DatabasePromo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DatabasePromo {
    // instance variables - replace the example below with your own
    private static ArrayList<Promo> PROMO_DATABASE;
    private static int lastId;

    /**
     * Constructor for objects of class DatabasePromo
     */
    public DatabasePromo() {
        PROMO_DATABASE = new ArrayList<Promo>();
        lastId = 0;
    }

    public static ArrayList<Promo> getPromoDatabase() {
        return PROMO_DATABASE;
    }

    public static int getLastId() {
        return lastId;
    }

    public static Promo getPromoById(int id) {
        for (Promo promo : PROMO_DATABASE) {
            if (promo.getId() == id) {
                return promo;
            }
        }
        return null;
    }

    public static Promo getPromoByCode(String code) {
        for (Promo promo : PROMO_DATABASE) {
            if (promo.getCode().equals(code)) {
                return promo;
            }
        }
        return null;
    }

    public boolean addPromo(Promo promo) {
        for (Promo promos : PROMO_DATABASE) {
            if (promos.getCode().equals(promo.getCode())) {
                return false;
            }
        }
        PROMO_DATABASE.add(promo);
        lastId = promo.getId();
        return true;
    }

    public boolean removePromo(int id) {
        for (Promo promo : PROMO_DATABASE) {
            if (promo.getId() == id) {
                PROMO_DATABASE.remove(promo);
                return true;
            }
        }
        return false;
    }

    public boolean activatePromo(int id) {
        for (Promo promo : PROMO_DATABASE) {
            if (promo.getId() == id) {
                promo.setActive(true);
                PROMO_DATABASE.set(PROMO_DATABASE.indexOf(promo), promo);
                return true;
            }
        }
        return false;
    }

    public boolean deactivatePromo(int id) {
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
