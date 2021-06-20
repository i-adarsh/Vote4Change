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
import java.util.Base64;

/**
 *
 * @author adarshkumar
 */
public class VoteDAO {
    private static PreparedStatement ps1,ps2,ps3;
    static{
        try{
            ps1 = DBConnection.getConnection().prepareStatement("Select candidate_id from voting where voter_id=?");
            ps2 = DBConnection.getConnection().prepareStatement("Select candidate_id,username,symbol from candidate,user_details where candidate.user_id=user_details.aadhar_no and candidate.candidate_id=?");
            //and ki jagah where
            ps3 = DBConnection.getConnection().prepareStatement("Insert into voting values(?,?)");
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
            blob = rs.getBlob(4);
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
            cd.setCandidateName(rs.getString(2));
            cd.setParty(rs.getString(3));
        }
        return cd;
    }
    public static boolean addVote(VoteDTO obj) throws SQLException{
        ps3.setString(1, obj.getCandidateId());
        ps3.setString(2, obj.getVoterId());
        return (ps3.executeUpdate() != 0);
    }
}
