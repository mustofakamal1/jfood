package mustofakamal.jfood.threading;

import mustofakamal.jfood.structure.model.Invoice;

/**
 * Class PriceCalculator adalah class yang berfungsi
 * memproses threading di jFood, tetapi belum siap diimplemntasikan.
 *
 * @author Mustofa Kamal
 * @version 07-06-2020
 */
public class PriceCalculator implements Runnable {
    private Thread t;
    private Invoice invoice;


    public PriceCalculator(Invoice invoice) {
        this.invoice = invoice;
    }

    @Override
    public void run() {
        try {
            System.out.println("calculating invoice id: " + invoice.getId());
            invoice.setTotalPrice();
            System.out.println("finish calculating invoice id: " + invoice.getId());
            Thread.sleep(50);
        } catch (InterruptedException e) {
            System.out.println("Thread Invoice " +  invoice.getId() + " interrupted.");
        }
    }

    public void start () {
        if (t == null) {
            t = new Thread (this);
            t.start ();
        }
    }
}
