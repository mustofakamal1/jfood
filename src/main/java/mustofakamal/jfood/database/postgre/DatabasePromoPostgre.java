package mustofakamal.jfood.database.postgre;

import mustofakamal.jfood.exception.PromoCodeAlreadyExistsException;
import mustofakamal.jfood.exception.PromoNotFoundExecption;
import mustofakamal.jfood.structure.model.Promo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DatabasePromoPostgre {
    public static boolean insertPromo(Promo promo) throws PromoCodeAlreadyExistsException {
        Connection c = null;
        Statement stmt = null;

        c = DatabaseConnectionPostgre.connection();

        try {
            stmt = c.createStatement();
            String sql = "INSERT INTO promo(id, code, discount, minprice) " +
                    "VALUES(" + promo.getId() + ",'" + promo.getCode() + "'," + promo.getDiscount() + ","
                    + promo.getMinPrice() + ");";
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
        return true;
    }

    public static int getLastPromoId(){
        Connection c = null;
        Statement stmt = null;
        int id = 0;

        c = DatabaseConnectionPostgre.connection();

        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT MAX(id) AS last_id FROM promo;");
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

    public static Promo getPromoByCode(String code) {
        Connection c = null;
        Statement stmt = null;
        Promo promo = null;

        c = DatabaseConnectionPostgre.connection();

        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM promo WHERE code = '" + code + "';");
            while (rs.next()){
                int id = rs.getInt("id");
                int discount = rs.getInt("discount");
                int minPrice = rs.getInt("minprice");
                boolean active = rs.getBoolean("active");
                promo = new Promo(id, code, discount, minPrice, active);
            }
            rs.close();
            stmt.close();
            c.close();
        }catch (Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Select promo successfully");
        return promo;
    }

    public static Promo getPromo(int id) throws PromoNotFoundExecption {
        Connection c = null;
        Statement stmt = null;
        Promo promo = null;

        c = DatabaseConnectionPostgre.connection();

        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM promo WHERE id = " + id + ";");
            while (rs.next()){
                String code = rs.getString("code");
                int discount = rs.getInt("discount");
                int minPrice = rs.getInt("minprice");
                boolean active = rs.getBoolean("active");
                promo = new Promo(id, code, discount, minPrice, active);
            }
            rs.close();
            stmt.close();
            c.close();
        }catch (Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Select promo successfully");
        return promo;
    }

    public static boolean removePromo(int id) throws PromoNotFoundExecption{
        Connection c = null;
        Statement stmt = null;

        c = DatabaseConnectionPostgre.connection();

        try {
            stmt = c.createStatement();
            String sql = "DELETE FROM promo WHERE id = " + id + ";";
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Remove promo successfully");
        return true;
    }

    public static ArrayList<Promo> getPromoDatabase() {
        ArrayList<Promo> promos = new ArrayList<>();

        Connection c = null;
        Statement stmt = null;
        int id;

        c = DatabaseConnectionPostgre.connection();

        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM promo;");
            while (rs.next()){
                id = rs.getInt("id");
                String code = rs.getString("code");
                int discount = rs.getInt("discount");
                int minPrice = rs.getInt("minprice");
                boolean active = rs.getBoolean("active");
                promos.add(new Promo(id, code, discount, minPrice, active));
            }
            rs.close();
            stmt.close();
            c.close();
        }catch (Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Select promo database successfully");
        return promos;
    }
}
