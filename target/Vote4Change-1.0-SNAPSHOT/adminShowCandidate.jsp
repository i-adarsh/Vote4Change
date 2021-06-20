<%-- 
    Document   : adminShowCandidate
    Created on : 19-Jun-2021, 8:26:41 pm
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
        
        System.out.println(displayBlock);
    }
    
    else if (result != null && result.equals("details")){
        
        CandidateDetails cd = (CandidateDetails)request.getAttribute("candidate");
        String str = "<img src='data:image/jpg;base64,"+cd.getSymbol()+"'style='width:300px;height:200px;'>";
        displayBlock.append("<table>");
        displayBlock.append("<tr><th>UserId:</th><td>" + cd.getCandidateId() + "</td></tr>");
        displayBlock.append("<tr><th>Candidate Name:</th><td>" + cd.getCandidateName() + "</td></tr>");
        displayBlock.append("<tr><th>City:</th><td>" + cd.getCity() + "</td></tr>");
        displayBlock.append("<tr><th>Party:</th><td>" + cd.getParty() + "</td></tr>");
        displayBlock.append("<tr><th>Symbol:</th><td>" + str + "</td></tr>");
        displayBlock.append("</table>");
        JSONObject json = new JSONObject();
        json.put("subdetails",displayBlock.toString());
        out.println(json);
        
        System.out.println(displayBlock);
    }
    
%>