package page_objects;

import org.openqa.selenium.WebDriver;

import java.sql.*;

public class Database extends Base {
    public Database(WebDriver driver) {
        super(driver);
    }
    public static Connection conn = null;
    public static String DB_URL ="jdbc:sqlite:InsuranceCalculatorDataBase1";
    public static Statement stmt;
    public static ResultSet res;

    public void ConnectToDatabase() throws SQLException {

        try {
            conn = DriverManager.getConnection(DB_URL);
            System.out.println("Connection to SQLite has been established.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        stmt = conn.createStatement();
        res = stmt.executeQuery("SELECT * FROM TypeOfVehicle WHERE LicensePlateRegistrationDate='02/12/2015';");

    }
}