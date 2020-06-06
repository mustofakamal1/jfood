package mustofakamal.jfood.exception;

/**
 * Class PromoNotFoundExecption adalah class yang berfungsi
 * memberikan peringatan promo tidak ditemukan.
 *
 * @author Mustofa Kamal
 * @version 07-06-2020
 */
public class PromoNotFoundExecption extends Exception {

    private int promo_error;

    public PromoNotFoundExecption (int promo_input) {
        super("Promo ID: ");
        this.promo_error = promo_input;
    }

    public String getMessage() {
        return super.getMessage() + promo_error + " not found";
    }
}
