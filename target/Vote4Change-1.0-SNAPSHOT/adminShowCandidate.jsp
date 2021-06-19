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
    }
    else if (result != null && result.equals("details")){
        CandidateDetails cd = (CandidateDetails)request.getAttribute("candidate");
        String str = "<img src='data:image/jpg;base64,"+cd.getSymbol()+"'style='width:300px;height:200px;'>";
    }
    JSONObject json = new JSONObject();
%>












