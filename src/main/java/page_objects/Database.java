package page_objects;

import org.openqa.selenium.WebDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database extends Base {
    public Database(WebDriver driver) {
        super(driver);
    }

    public void ConnectToDatabase(){
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:C:\\Users\\mpodsiadly_adm\\Downloads\\InsuranceCalculatorDataBase1.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);

            System.out.println("Connection to SQLite has been established.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}