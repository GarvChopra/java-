import java.sql.*;

public class conn1 {
    Connection c;
    Statement s;

    public conn1() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/bankmanegmentsystem",
                "root",
                "garv@2025"
            );
            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
