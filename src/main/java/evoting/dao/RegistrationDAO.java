/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evoting.dao;

import evoting.dbutil.DBConnection;
import evoting.dto.UserDetails;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author adarshkumar
 */
public class RegistrationDAO {
    private static PreparedStatement ps, ps1;
    static {
        try {
            ps = DBConnection.getConnection().prepareStatement("Select * from user_details where aadhar_no=?");
            ps1 = DBConnection.getConnection().prepareStatement("Insert into user_details values (?,?,?,?,?,?,?,?,?)");
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
    }
    public static boolean searchUser (String userID) throws SQLException{
        ps.setString(1, userID);
        return ps.executeQuery().next();
    }
    public static boolean registerUser(UserDetails user) throws SQLException{
        ps1.setString(1, user.getUserID());
        ps1.setString(2, user.getPassword());
        ps1.setString(3, user.getUserName());
        ps1.setString(4, user.getAddress());
        ps1.setString(5, user.getCity());
        ps1.setString(6, user.getEmail());
        ps1.setString(7, user.getMobile());
        ps1.setString(8, "Voter");
        ps1.setString(9, user.getGender());
        return ps1.executeUpdate() == 1;
    }
}
