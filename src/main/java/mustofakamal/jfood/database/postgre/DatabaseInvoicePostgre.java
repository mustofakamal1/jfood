package mustofakamal.jfood.database.postgre;

import mustofakamal.jfood.exception.InvoiceNotFoundException;
import mustofakamal.jfood.exception.OngoingInvoiceAlreadyExistsException;
import mustofakamal.jfood.structure.model.CashInvoice;
import mustofakamal.jfood.structure.model.CashlessInvoice;
import mustofakamal.jfood.structure.model.Food;
import mustofakamal.jfood.structure.model.Invoice;
import mustofakamal.jfood.structure.type.InvoiceStatus;
import mustofakamal.jfood.structure.type.PaymentType;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class DatabaseInvoicePostgre {

    public static boolean insertCashlessInvoice(CashlessInvoice invoice) throws OngoingInvoiceAlreadyExistsException {
        if(checkOnGoing(invoice.getCustomer().getId())) {
            throw new OngoingInvoiceAlreadyExistsException(invoice);
        }
        Connection c = null;
        Statement stmt = null;
        String addPromo = null;
        if(invoice.getPromo() != null) {
            addPromo = invoice.getPromo().getCode();
        }

        c = DatabaseConnectionPostgre.connection();

        try {
            stmt = c.createStatement();
            String sql = "INSERT INTO invoice(id, customer, invoice_status, promo, payment_type, total_price) " +
                    "VALUES(" + invoice.getId() + ",'" + invoice.getCustomer().getId()
                    + "','" + InvoiceStatus.Ongoing + "','" + addPromo + "','" +
                    PaymentType.Cashless + "','" + invoice.getTotalPrice() + "');";
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
            System.out.println("Records created unsuccessfully");
            return false;
        }
        System.out.println("Records created successfully");
        setInvoiceFood(invoice.getId(), invoice.getFoods());
        return true;
    }

    public static boolean insertCashInvoice(CashInvoice invoice) throws OngoingInvoiceAlreadyExistsException {
        if(checkOnGoing(invoice.getCustomer().getId())) {
            throw new OngoingInvoiceAlreadyExistsException(invoice);
        }
        Connection c = null;
        Statement stmt = null;

        c = DatabaseConnectionPostgre.connection();

        try {
            stmt = c.createStatement();
            String sql = "INSERT INTO invoice(id, customer, invoice_status, delivery_fee, payment_type, total_price) " +
                    "VALUES(" + invoice.getId() + "," + invoice.getCustomer().getId() + ",'" +
                    InvoiceStatus.Ongoing + "'," + invoice.getDeliveryFee() + ",'" +
                    PaymentType.Cash + "'," + invoice.getTotalPrice() + ");";
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.out.println("Records created unsucasa;jsa;js;cessfully");
            return false;
        }
        System.out.println("Records created successfully");
        setInvoiceFood(invoice.getId(), invoice.getFoods());
        return true;
    }

    public static int getLastInvoiceId(){
        Connection c = null;
        Statement stmt = null;
        int id = 0;

        c = DatabaseConnectionPostgre.connection();

        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT MAX(id) AS last_id FROM invoice;");
            while (rs.next()){
                id = rs.getInt("last_id");
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Select last id successfully");
        return id;
    }

    public static Invoice getInvoice(int id) throws InvoiceNotFoundException {
        ArrayList<Food> foods = new ArrayList<>();
        Connection c = null;
        Statement stmt = null;
        Invoice invoice = null;

        c = DatabaseConnectionPostgre.connection();

        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM invoice WHERE id = " + id + ";");
            while (rs.next()){
                int customer = rs.getInt("customer");
                Date date = rs.getDate("date");
                String invoiceStatus = rs.getString("invoice_status");
                int deliveryFee = rs.getInt("delivery_fee");
                String paymentType = rs.getString("payment_type");
                String promo = rs.getString("promo");
                int totalPrice = rs.getInt("total_price");

                Calendar calendar = new GregorianCalendar();
                calendar.setTime(date);

                if (paymentType.equals(PaymentType.Cash.toString())) {
                    invoice = new CashInvoice(id, foods, DatabaseCustomerPostgre.getCustomer(customer), deliveryFee);
                }
                else if (paymentType.equals(PaymentType.Cashless.toString())) {
                    invoice = new CashlessInvoice(id, foods, DatabaseCustomerPostgre.getCustomer(customer),
                            DatabasePromoPostgre.getPromoByCode(promo));
                }
                else {
                    return null;
                }
                invoice.setDate(calendar);
                invoice.setInvoiceStatus(stringToStatus(invoiceStatus));
                invoice.setTotalPrice(totalPrice);
            }
            rs.close();
            stmt.close();
            c.close();
        }catch (Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Select invoice successfully");
        return invoice;
    }

    public static boolean removeInvoice(int id) throws InvoiceNotFoundException{
        Connection c = null;
        Statement stmt = null;

        c = DatabaseConnectionPostgre.connection();

        try {
            stmt = c.createStatement();
            String sql = "DELETE FROM invoice WHERE id = " + id + ";";
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Remove invoice successfully");
        return true;
    }

    public static ArrayList<Invoice> getInvoiceDatabase() {
        ArrayList<Invoice> invoices = new ArrayList<>();
        ArrayList<Food> foods = new ArrayList<>();
        Connection c = null;
        Statement stmt = null;
        Invoice invoice = null;

        c = DatabaseConnectionPostgre.connection();

        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM invoice ORDER BY id;");
            while (rs.next()){
                int id = rs.getInt("id");
                int customer = rs.getInt("customer");
                Date date = rs.getDate("date");
                String invoiceStatus = rs.getString("invoice_status");
                int deliveryFee = rs.getInt("delivery_fee");
                String paymentType = rs.getString("payment_type");
                String promo = rs.getString("promo");
                int totalPrice = rs.getInt("total_price");

                Calendar calendar = new GregorianCalendar();
                calendar.setTime(date);

                foods = getInvoiceFood(id);

                if (paymentType.equals(PaymentType.Cash.toString())) {
                    invoice = new CashInvoice(id, foods, DatabaseCustomerPostgre.getCustomer(customer), deliveryFee);
                }
                else if (paymentType.equals(PaymentType.Cashless.toString())) {
                    invoice = new CashlessInvoice(id, foods, DatabaseCustomerPostgre.getCustomer(customer),
                            DatabasePromoPostgre.getPromoByCode(promo));
                }
                else {
                    return null;
                }
                invoice.setDate(calendar);
                invoice.setInvoiceStatus(stringToStatus(invoiceStatus));
                invoice.setTotalPrice(totalPrice);
                invoices.add(invoice);
            }
            rs.close();
            stmt.close();
            c.close();
        }catch (Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.out.println("Select invoice database failed");
        }
        System.out.println("Select invoice database successfully");
        return invoices;
    }

    public static ArrayList<Invoice> getInvoiceByCustomer(int customer) {
        ArrayList<Invoice> invoices = new ArrayList<>();
        ArrayList<Food> foods = new ArrayList<>();
        Connection c = null;
        Statement stmt = null;
        Invoice invoice = null;

        c = DatabaseConnectionPostgre.connection();

        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM invoice WHERE customer = " + customer + ";");
            while (rs.next()){
                int id = rs.getInt("id");
                Date date = rs.getDate("date");
                String invoiceStatus = rs.getString("invoice_status");
                int deliveryFee = rs.getInt("delivery_fee");
                String paymentType = rs.getString("payment_type");
                String promo = rs.getString("promo");
                int totalPrice = rs.getInt("total_price");

                Calendar calendar = new GregorianCalendar();
                calendar.setTime(date);

                foods = getInvoiceFood(id);
//                if(foods.isEmpty()){
//                    foods = DatabaseFoodPostgre.getFoodDatabase();
//                }

                if (paymentType.equals(PaymentType.Cash.toString())) {
                    invoice = new CashInvoice(id, foods, DatabaseCustomerPostgre.getCustomer(customer), deliveryFee);
                }
                else if (paymentType.equals(PaymentType.Cashless.toString())) {
                    invoice = new CashlessInvoice(id, foods, DatabaseCustomerPostgre.getCustomer(customer),
                            DatabasePromoPostgre.getPromoByCode(promo));
                }
                else {
                    System.out.println("PaymentTypeNotKnown");
                    continue;
                }
                invoice.setDate(calendar);
                invoice.setInvoiceStatus(stringToStatus(invoiceStatus));
                invoice.setTotalPrice(totalPrice);
                invoices.add(invoice);
            }
            rs.close();
            stmt.close();
            c.close();
        }catch (Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Select invoice database successfully");
        return invoices;
    }

    public static boolean changeInvoiceStatus(int id, InvoiceStatus invoiceStatus) {
        Connection c = null;
        Statement stmt = null;

        c = DatabaseConnectionPostgre.connection();

        try {
            stmt = c.createStatement();
            String sql = "UPDATE invoice set invoice_status = '"+ invoiceStatus +"' WHERE id = " + id + " AND" +
                    " invoice_status = '"+ InvoiceStatus.Ongoing +"';";
            if(stmt.executeUpdate(sql) == 0){
                return false;
            }
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.out.println("change invoice failed");
            return false;
        }
        System.out.println("change invoice successfully");
        return true;
    }

    private static InvoiceStatus stringToStatus(String invoiceStatus) {
        InvoiceStatus status = null;
        switch (invoiceStatus) {
            case "Ongoing":
                status = InvoiceStatus.Ongoing;
                break;
            case "Finished":
                status = InvoiceStatus.Finished;
                break;
            case "Cancelled":
                status = InvoiceStatus.Cancelled;
                break;
            default:
        }
        return status;
    }

    public static ArrayList<Food> getInvoiceFood(int invoice) {
        ArrayList<Food> foods = new ArrayList<>();
        ArrayList<Integer> food_id = new ArrayList<>();
        Connection c = null;
        Statement stmt = null;

        c = DatabaseConnectionPostgre.connection();

        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT food FROM invoice_food WHERE invoice = " + invoice +";");
            while (rs.next()){
                int foodId = rs.getInt("food");

                Food food = DatabaseFoodPostgre.getFood(foodId);
                foods.add(food);
            }
            rs.close();
            stmt.close();
            c.close();
        }catch (Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.out.println("Select invoice_food database failed");
        }
        System.out.println("Select invoice_food database successfully");
        return foods;
    }

    private static boolean setInvoiceFood(int id, ArrayList<Food> foods) {
        for (Food food : foods) {
            Connection c = null;
            Statement stmt = null;

            c = DatabaseConnectionPostgre.connection();

            try {
                stmt = c.createStatement();
                String sql = "INSERT INTO invoice_food(invoice, food) " +
                        "VALUES(" + id + "," + food.getId() + ");";
                stmt.executeUpdate(sql);
                stmt.close();
                c.close();
            } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);
                System.out.println("Records created unsuccessfully");
                return false;
            }
            System.out.println("Records created successfully");
        }
        return true;
    }

    private static boolean checkOnGoing(int id) {
        for(Invoice inv: getInvoiceByCustomer(id)) {
            if(inv.getInvoiceStatus().equals(InvoiceStatus.Ongoing)) {
                return true;
            }
        }
        return false;
    }
}