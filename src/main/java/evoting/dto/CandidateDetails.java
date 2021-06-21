/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evoting.dto;

import java.util.Objects;

/**
 *
 * @author adarshkumar
 */
public class CandidateDetails {

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.CandidateId);
        hash = 53 * hash + Objects.hashCode(this.userId);
        hash = 53 * hash + Objects.hashCode(this.candidateName);
        hash = 53 * hash + Objects.hashCode(this.symbol);
        hash = 53 * hash + Objects.hashCode(this.party);
        hash = 53 * hash + Objects.hashCode(this.city);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CandidateDetails other = (CandidateDetails) obj;
        if (!Objects.equals(this.CandidateId, other.CandidateId)) {
            return false;
        }
        if (!Objects.equals(this.userId, other.userId)) {
            return false;
        }
        if (!Objects.equals(this.candidateName, other.candidateName)) {
            return false;
        }
        if (!Objects.equals(this.symbol, other.symbol)) {
            return false;
        }
        if (!Objects.equals(this.party, other.party)) {
            return false;
        }
        if (!Objects.equals(this.city, other.city)) {
            return false;
        }
        return true;
    }

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
