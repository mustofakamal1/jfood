package mustofakamal.jfood.database.postgre;

import mustofakamal.jfood.structure.model.Seller;
import mustofakamal.jfood.exception.SellerNotFoundException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DatabaseSellerPostgre {
    public static boolean insertSeller(Seller seller) {
        Connection c = null;
        Statement stmt = null;

        c = DatabaseConnectionPostgre.connection();

        try {
            stmt = c.createStatement();
            String sql = "INSERT INTO seller(id, name, email, phonenumber, location) " +
                    "VALUES(" + seller.getId() + ",'" + seller.getName() + "','" + seller.getEmail() + "','"
                    + seller.getPhoneNumber() + "'," + seller.getLocation().getId() + ");";
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

    public static int getLastSellerId(){
        Connection c = null;
        Statement stmt = null;
        int id = 0;

        c = DatabaseConnectionPostgre.connection();

        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT MAX(id) AS last_id FROM seller;");
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

    public static Seller getSeller(int id) throws SellerNotFoundException {
        Connection c = null;
        Statement stmt = null;
        Seller seller = null;

        c = DatabaseConnectionPostgre.connection();

        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM seller WHERE id = " + id + ";");
            while (rs.next()){
                String name = rs.getString("name");
                String email = rs.getString("email");
                String phoneNumber = rs.getString("phonenumber");
                int location = rs.getInt("location");
                seller = new Seller(id, name, email, phoneNumber, DatabaseLocationPostgre.getLocation(location));
            }
            rs.close();
            stmt.close();
            c.close();
        }catch (Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Select seller successfully");
        return seller;
    }

    public static boolean removeSeller(int id) throws SellerNotFoundException{
        Connection c = null;
        Statement stmt = null;

        c = DatabaseConnectionPostgre.connection();

        try {
            stmt = c.createStatement();
            String sql = "DELETE FROM seller WHERE id = " + id + ";";
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Remove seller successfully");
        return true;
    }

    public static ArrayList<Seller> getSellerDatabase() {
        ArrayList<Seller> sellers = new ArrayList<>();

        Connection c = null;
        Statement stmt = null;
        int id = 0;

        c = DatabaseConnectionPostgre.connection();

        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM seller;");
            while (rs.next()){
                id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String phoneNumber = rs.getString("phonenumber");
                int location = rs.getInt("location");
                sellers.add(new Seller(id, name, email, phoneNumber, DatabaseLocationPostgre.getLocation(location)));
            }
            rs.close();
            stmt.close();
            c.close();
        }catch (Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Select seller database successfully");
        return sellers;
    }
}
