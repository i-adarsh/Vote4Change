<%-- 
    Document   : electionResult
    Created on : 21-Jun-2021, 11:26:53 pm
    Author     : adarshkumar
--%>

<%@page import="java.util.Map"%>
<%@page import="java.util.Iterator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="evoting.dto.CandidateDetails,java.util.LinkedHashMap" %>

<%
    String userID = (String)session.getAttribute("userID");
    if (userID == null){
        session.invalidate();
        response.sendRedirect("accessDenied.html");
        return;
    }
    LinkedHashMap<CandidateDetails, Integer> resultDetails = (LinkedHashMap)request.getAttribute("result");
    int votecount = (int)request.getAttribute("votecount");
    Iterator it = resultDetails.entrySet().iterator();
    StringBuffer displayBlock = new StringBuffer("<table>");
    displayBlock.append("<tr><th>Candidate Id</th><th>Candidate Name</th><th>Party</th><th>Symbol</th><th>City</th><th>Vote Count</th><th>Vote %</th></tr>");
    while(it.hasNext()){
        Map.Entry<CandidateDetails, Integer> e = (Map.Entry)it.next();
        CandidateDetails cd = e.getKey();
        float votePer = (e.getValue()*100.0f)/100;
        displayBlock.append("<tr><td>"+ cd.getCandidateId() + "</td><td>" + cd.getCandidateName() + "</td><td>" + cd.getParty() + "</td><td><img src='data:image/jpg;base64," +cd.getSymbol() + "' style='width:300px;height:200px;'/></td><td>" + cd.getCity() + "</td><td>" + e.getValue() + "</td><td>" + votePer + "</td></tr>");
    }
    displayBlock.append("</table>");
    out.println(displayBlock);
%>
