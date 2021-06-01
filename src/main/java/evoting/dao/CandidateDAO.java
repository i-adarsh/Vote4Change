/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evoting.dao;

import evoting.dbutil.DBConnection;
import evoting.dto.CandidateDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author adarshkumar
 */
public class CandidateDAO {
    private static PreparedStatement ps, ps1, ps2, ps3;
    static{
        try{
            ps = DBConnection.getConnection().prepareStatement("Select count(*) from candidate");
            ps1 = DBConnection.getConnection().prepareStatement("Select username from user_details where aadhar_no=?");
            ps2 = DBConnection.getConnection().prepareStatement("Select distinct city from user_details");
            ps3 = DBConnection.getConnection().prepareStatement("insert into candidate values(?,?,?,?,?)");
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
    }
    
    public static String getNewId() throws SQLException{
        ResultSet rs = ps.executeQuery();
        rs.next();
        return "C"+(100+rs.getInt(1) + 1);
//        if (rs.next()){
//            return "C"+(100+rs.getInt(1) + 1);
//        }
//        else{
//            return "C101";
//        }
    }
    
    public static String getUserNameById(String uid) throws SQLException{
        ps1.setString(1, uid);
        ResultSet rs = ps1.executeQuery();
        if (rs.next()){
            return rs.getString(1);
        }
        else{
            return null;
        }
    }
    
    public static ArrayList<String> getCity() throws SQLException{
        ArrayList <String> cityList = new ArrayList<>();
        ResultSet rs = ps2.executeQuery();
        while(rs.next()){
            cityList.add(rs.getString(1));
        }
        return cityList;
    }
    
    public static boolean addCandidate(CandidateDTO obj) throws SQLException{
        
    }
    
}
