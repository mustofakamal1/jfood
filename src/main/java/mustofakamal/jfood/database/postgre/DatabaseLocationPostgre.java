package mustofakamal.jfood.database.postgre;

import mustofakamal.jfood.structure.model.Location;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DatabaseLocationPostgre {
    public static boolean insertLocation(Location location) {
        Connection c = null;
        Statement stmt = null;

        c = DatabaseConnectionPostgre.connection();

        try {
            stmt = c.createStatement();
            String sql = "INSERT INTO location(id, city, province, description) " +
                    "VALUES(" + location.getId() + ",'" + location.getCity() + "','" + location.getProvince() + "','"
                    + location.getDescription() + "');";
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

    public static int getLastLocationId(){
        Connection c = null;
        Statement stmt = null;
        int id = 0;

        c = DatabaseConnectionPostgre.connection();

        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT MAX(id) AS last_id FROM location;");
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

    public static Location getLocation(int id) {
        Connection c = null;
        Statement stmt = null;
        Location location = null;

        c = DatabaseConnectionPostgre.connection();

        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM location WHERE id = " + id + ";");
            while (rs.next()){
                String city = rs.getString("city");
                String province = rs.getString("province");
                String description = rs.getString("description");
                location = new Location(id, city, province, description);
            }
            rs.close();
            stmt.close();
            c.close();
        }catch (Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Select location successfully");
        return location;
    }

    public static boolean removeLocation(int id) {
        Connection c = null;
        Statement stmt = null;

        c = DatabaseConnectionPostgre.connection();

        try {
            stmt = c.createStatement();
            String sql = "DELETE FROM location WHERE id = " + id + ";";
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Remove location successfully");
        return true;
    }

    public static ArrayList<Location> getLocationDatabase() {
        ArrayList<Location> locations = new ArrayList<>();

        Connection c = null;
        Statement stmt = null;
        int id = 0;

        c = DatabaseConnectionPostgre.connection();

        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM location;");
            while (rs.next()){
                String city = rs.getString("city");
                String province = rs.getString("province");
                String description = rs.getString("description");
                locations.add(new Location(id, city, province, description));
            }
            rs.close();
            stmt.close();
            c.close();
        }catch (Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Select location database successfully");
        return locations;
    }
}