/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.diit.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Kamrul
 */
public class DataBaseUtil {

    private Connection con;
    private String user = "root";
    private String password = "123";
    private String url = "jdbc:mysql://localhost:3306/tollcollection";

    public DataBaseUtil() throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
    }

    public Connection getCon() throws SQLException {
        con = DriverManager.getConnection(url, user, password);
        return con;
    }
}
