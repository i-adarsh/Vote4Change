/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evoting.dto;

/**
 *
 * @author adarshkumar
 */
public class CandidateDetails {

    @Override
    public String toString() {
        return "CandidateDetails{" + "CandidateId=" + CandidateId + ", userId=" + userId + ", candidateNAme=" + candidateName + ", symbol=" + symbol + ", party=" + party + ", city=" + city + '}';
    }

    public String getCandidateId() {
        return CandidateId;
    }

    public void setCandidateId(String CandidateId) {
        this.CandidateId = CandidateId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateNAme(String candidateNAme) {
        this.candidateName = candidateNAme;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getParty() {
        return party;
    }

    public void setParty(String party) {
        this.party = party;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    private String CandidateId;
    private String userId;
    private String candidateName;
    private String symbol;
    private String party;
    private String city;
    
}
