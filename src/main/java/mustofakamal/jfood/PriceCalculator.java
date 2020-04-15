package mustofakamal.jfood;
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
