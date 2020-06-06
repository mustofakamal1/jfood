package mustofakamal.jfood.exception;

/**
 * Class SellerNotFoundException adalah class yang berfungsi
 * memberikan peringatan seller tidak ditemukan.
 *
 * @author Mustofa Kamal
 * @version 07-06-2020
 */
public class SellerNotFoundException extends Exception {

    private int seller_error;

    public SellerNotFoundException (int seller_input) {
        super("Seller ID: ");
        this.seller_error = seller_input;
    }

    public String getMessage() {
        return super.getMessage() + seller_error + " not found";
    }
}
