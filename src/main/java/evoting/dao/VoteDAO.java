/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evoting.dao;

import static evoting.dao.CandidateDAO.getUserNameById;
import evoting.dbutil.DBConnection;
import evoting.dto.CandidateDetails;
import evoting.dto.CandidateInfo;
import evoting.dto.VoteDTO;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Base64;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author adarshkumar
 */
public class VoteDAO {
    private static PreparedStatement ps1,ps2,ps3,ps4,ps5,ps6,ps7;
    private static Statement st;
    static{
        try{
            ps1 = DBConnection.getConnection().prepareStatement("Select candidate_id from voting where voter_id=?");
            ps2 = DBConnection.getConnection().prepareStatement("Select candidate_id,username,symbol from candidate,user_details where candidate.user_id=user_details.aadhar_no and candidate.candidate_id=?");
            //and ki jagah where
            ps3 = DBConnection.getConnection().prepareStatement("Insert into voting values(?,?,?)");
            ps4 = DBConnection.getConnection().prepareStatement("select candidate_id,count(*) as votes_obt from voting group by candidate_id order by votes_obt desc");
            st = DBConnection.getConnection().createStatement();
            ps5 = DBConnection.getConnection().prepareStatement("select count(*) from voting");
            ps6 = DBConnection.getConnection().prepareStatement("select count(*) from voting where gender='Male'");
            ps7 = DBConnection.getConnection().prepareStatement("select  candidate.party, count(*) from candidate, voting where candidate.candidate_id=voting.candidate_id group by candidate.party");
            
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
    }
    public static String getCandidateId(String userid) throws SQLException{
        ps1.setString(1, userid);
        ResultSet rs = ps1.executeQuery();
        if (rs.next()){
            return rs.getString(1);
            //userid
        }
        return null;
    }
    public static CandidateInfo getVote(String candidateid) throws Exception{
        ps2.setString(1, candidateid);
        ResultSet rs = ps2.executeQuery();
        CandidateInfo cd = new CandidateInfo();
        Blob blob;
        InputStream inputStream;
        byte [] buffer;
        byte [] imageBytes;
        int bytesRead;
        String base64Image;
        ByteArrayOutputStream outputStream; 
        if (rs.next()){
            System.out.println(rs.toString());
            blob = rs.getBlob(3);
            inputStream = blob.getBinaryStream();
            outputStream = new ByteArrayOutputStream();
            buffer = new byte[4096];
            bytesRead = -1;
            while((bytesRead=inputStream.read(buffer))!= -1){
                outputStream.write(buffer, 0, bytesRead);
            }
            imageBytes = outputStream.toByteArray();
            Base64.Encoder en = Base64.getEncoder();
            base64Image = en.encodeToString(imageBytes);
            cd.setSymbol(base64Image);
            cd.setCandidateId(candidateid);
            cd.setCandidateName(rs.getString(1));
            cd.setParty(rs.getString(2));
        }
        return cd;
    }
    
    public static boolean addVote(VoteDTO obj) throws SQLException{
        ps3.setString(1, obj.getCandidateId());
        ps3.setString(2, obj.getVoterId());
        ps3.setString(3, obj.getGender());
        return (ps3.executeUpdate() != 0);
    }

    
    public static Map<String,Integer> getResult() throws SQLException{
        Map<String, Integer> result = new LinkedHashMap<>();
        ResultSet rs = ps4.executeQuery();
        while(rs.next()){
            result.put(rs.getString(1), rs.getInt(2));
        }
        return result;
    }
    
    public static Map<String, Integer> getResultBasedOnParty() throws SQLException {
        Map<String, Integer> result = new LinkedHashMap<>();
        ResultSet rs = ps7.executeQuery();
        while(rs.next())
        {
            System.out.println("Party : "+rs.getString(1));
            System.out.println("Votes Count : "+rs.getInt(2));
            result.put(rs.getString(1), rs.getInt(2));
        }
        return result;
    }
    
    public static String getGenderPercentage() throws SQLException{
        ResultSet rs = ps6.executeQuery();
        rs.next();
        String num = "" + rs.getInt(1);
        rs = ps5.executeQuery();
        rs.next();
        num += ":" + rs.getInt(1);
        return num;
    }
    
    public static int getVoteCount() throws SQLException{
        
        ResultSet rs = st.executeQuery("select count(*) from voting");
        System.out.println("Inside DAO");
        if (rs.next()){
            return rs.getInt(1);
        }
        return 0;
    }
}
