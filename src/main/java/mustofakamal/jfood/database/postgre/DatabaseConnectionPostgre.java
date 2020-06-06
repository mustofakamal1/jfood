package mustofakamal.jfood.database.postgre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Class DatabaseConnectionPostgre adalah class yang berfungsi
 * membuat konkesi ke database postgreSQL.
 *
 * @author Mustofa Kamal
 * @version 07-06-2020
 */
public class DatabaseConnectionPostgre {
    public static Connection connection(){
        Connection c = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jfood", "postgres", "");
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (Exception e){
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return c;
    }
}
