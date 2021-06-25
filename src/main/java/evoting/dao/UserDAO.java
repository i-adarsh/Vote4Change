/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evoting.dao;

import evoting.dbutil.DBConnection;
import evoting.dto.UserDTO;
import evoting.dto.UserDetails;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author adarshkumar
 */
public class UserDAO {
    private static PreparedStatement ps,ps1,ps2;
    private static Statement st;
    static{
        try{
            st = DBConnection.getConnection().createStatement();
            ps = DBConnection.getConnection().prepareStatement("Select user_type from user_details where aadhar_no=? and password=?");
            ps1 = DBConnection.getConnection().prepareStatement("Delete from user_details where aadhar_no=?");
            ps2 = DBConnection.getConnection().prepareStatement("Select username , email,mobile_no,address,City from user_details where aadhar_no=?");
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
    }
    public static String validateUser(UserDTO user) throws SQLException{
        ps.setString(1, user.getUserID());
        ps.setString(2, user.getPassword());
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            String s = rs.getString(1);
            System.out.println(s);
            return s;
        }
        return null;
    }
    
    public static boolean deleteUserById(String userId) throws SQLException {
        System.out.println("Inside UserDAO in Delete User");
        ps1.setString(1, userId);
        return ps1.executeUpdate() != 0;
        
    }
    
    public static ArrayList<UserDetails> getUserDetailsById(String userId) throws SQLException {
        ArrayList<UserDetails> userDetails = new ArrayList<>();
        ps2.setString(1,userId);
        ResultSet rs = ps2.executeQuery();
        while(rs.next()){
            UserDetails ud = new UserDetails();
            ud.setUserID(userId);
            ud.setUserName(rs.getString(1));
            ud.setEmail(rs.getString(2));
            ud.setMobile(rs.getString(3));
            ud.setAddress(rs.getString(4));
            ud.setCity(rs.getString(5));
            userDetails.add(ud);
        }
        return userDetails;
    }
    
    public static List<UserDetails> getUserDetails() throws SQLException {
        System.out.println("Inside DAO");
        ArrayList<UserDetails> userDetails = new ArrayList<>();
        ResultSet rs = st.executeQuery("Select aadhar_no, username,address, city, email,mobile_no,gender from user_details where aadhar_no NOT IN (select aadhar_no from user_details where user_type='Admin' )");
        while(rs.next()){
            UserDetails ud = new UserDetails();
            ud.setUserID(rs.getString(1));
            ud.setUserName(rs.getString(2));
            ud.setAddress(rs.getString(3));
            ud.setCity(rs.getString(4));
            ud.setEmail(rs.getString(5));
            ud.setMobile(rs.getString(6));
            System.out.println("User Details : "+ud);
            userDetails.add(ud);
            
        }
        return userDetails;
    }
    
    public static ArrayList<String> getAllUserIds() throws SQLException
    {
        ArrayList<String> userIdList = new ArrayList<>();
        
        ResultSet rs = st.executeQuery("select aadhar_no from user_details where aadhar_no NOT IN (select aadhar_no from user_details where user_type='Admin')");
        while(rs.next()){
            userIdList.add(rs.getString(1));
        }
        return userIdList;
    }
    
    
}
