/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evoting.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author adarshkumar
 */
public class DBConnection {
    private static Connection conn = null;
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded Successfully");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Voting", "evoting", "adarsh");
            System.out.println("Connection Successfully Opened !");

        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
            
        }
        catch (SQLException sqlex){
            sqlex.printStackTrace();
        }
    }
    public static Connection getConnection(){
        return conn;
    }
    public static void closeConnection(){
        try {
            if (conn != null)
                conn.close();
        }catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Exception is : "+ex);
        }
    }
    
}
