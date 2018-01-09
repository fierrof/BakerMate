package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBManager {

    private Connection conn;
    private ResultSet rs;

    public void openConnection() {
        try {
            String url = "jdbc:derby://localhost:1527/BakeryDB";
            conn = DriverManager.getConnection(url, "root", "root");

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void closeConnection() {
        try {
            conn.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void SQLInsert(String sql) {

        try {
            openConnection();
            Statement st = conn.createStatement();
            st.executeUpdate(sql);

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public ResultSet SQLSelect(String sql) {
        try {
            openConnection();
            Statement st = conn.createStatement();
            rs = st.executeQuery(sql);
//            System.out.println(sql);

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return rs;
    }

    public void SQLUpdate() {

    }

    public void SQLDelete() {

    }

}
