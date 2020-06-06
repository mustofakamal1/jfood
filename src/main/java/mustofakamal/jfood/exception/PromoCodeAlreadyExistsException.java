package mustofakamal.jfood.exception;

import mustofakamal.jfood.structure.model.Promo;

/**
 * Class PromoCodeAlreadyExistsException adalah class yang berfungsi
 * memberikan peringatan ketika promo code sudah terdapat pada sistem.
 *
 * @author Mustofa Kamal
 * @version 07-06-2020
 */
public class PromoCodeAlreadyExistsException extends Exception {

    private Promo promo_error;

    public PromoCodeAlreadyExistsException (Promo promo_input) {
        super("Promo Code: ");
        this.promo_error = promo_input;
    }

    public String getMessage() {
        return super.getMessage() + promo_error.getCode() + " already exists.";
    }
}
