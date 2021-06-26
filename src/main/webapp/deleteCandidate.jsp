<%-- 
    Document   : showDeleteCandidate
    Created on : 22-Jun-2021, 11:57:16 pm
    Author     : adarshkumar
--%>

    <%@page contentType="text/html" pageEncoding="UTF-8"%>
        <%@page import="java.util.ArrayList" %>
            <%@page import="evoting.dto.CandidateDetails" %>
                <%@page import="org.json.JSONObject" %>

                    <%
    String userID = (String)session.getAttribute("userID");
    if (userID == null){
        response.sendRedirect("accessDenied.html");
        return;
    }
    String result = (String)request.getAttribute("result");
    
    StringBuffer displayBlock = new StringBuffer();
    if (result != null && result.equalsIgnoreCase("candidatelist")){
        ArrayList<String> candidateId = (ArrayList<String>)request.getAttribute("candidateid");
        displayBlock.append("<option>Choose Id</options>");
        for (String c : candidateId){
            displayBlock.append("<option value='"+c+"'>"+c+"</option>");
        }
        JSONObject json = new JSONObject();
        json.put("cid", displayBlock.toString());
        out.println(json);
    }
    
    else if (result != null && result.equals("details")){
        
        CandidateDetails cd = (CandidateDetails)request.getAttribute("candidate");
        String str = "<img src='data:image/jpg;base64,"+cd.getSymbol()+"'style='width:300px;height:200px;'>";
        displayBlock.append("<table>");
        displayBlock.append("<tr><th>UserId:</th><td>" + cd.getUserId() + "</td></tr>");
        displayBlock.append("<tr><th>Candidate Name:</th><td>" + cd.getCandidateName() + "</td></tr>");
        displayBlock.append("<tr><th>City:</th><td>" + cd.getCity() + "</td></tr>");
        displayBlock.append("<tr><th>Party:</th><td>" + cd.getParty() + "</td></tr>");
        displayBlock.append("<tr><th>Symbol:</th><td>" + str + "</td></tr>");
        displayBlock.append("</table>");
        displayBlock.append("<input type='button' value='Delete' onclick='deleteChoosenCandidate()'>");
        displayBlock.append("<p id='delete' hidden>"+ cd.getUserId() + "</p>");
        JSONObject json = new JSONObject();
        json.put("subdetails",displayBlock.toString());
        out.println(json);
    }
    
%>