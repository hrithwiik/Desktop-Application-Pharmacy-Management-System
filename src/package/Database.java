import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
public static Connection connectDb(){
try {
    Class.forName("com.mysql.cj.jdbc.Driver");  // Load driver
    String url = "jdbc:mysql://localhost/pharmacy";   // database URL
    Connection connect= DriverManager.getConnection(url, "root", "");
    return connect;
} catch (Exception e) {
  System.out.println("\n Error creating connection to database : " + e);
}
return null;
}
}
