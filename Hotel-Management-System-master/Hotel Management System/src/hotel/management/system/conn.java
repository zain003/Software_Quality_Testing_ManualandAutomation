package hotel.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class conn implements AutoCloseable {
    public Connection c;
    public Statement s;

    public conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///hms","root","zainalikhan");
            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() {
        try {
            if (s != null) s.close();
            if (c != null) c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
