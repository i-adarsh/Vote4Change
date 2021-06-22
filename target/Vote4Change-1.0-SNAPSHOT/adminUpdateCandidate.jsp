<%-- 
    Document   : adminUpdateCandidate
    Created on : 22-Jun-2021, 4:07:34 pm
    Author     : adarshkumar
--%>

    <%@page contentType="text/html" pageEncoding="UTF-8"%>
        <%@page import="java.util.ArrayList" %>
            <%@page import="evoting.dto.CandidateDetails" %>
            <%@page import="evoting.dao.CandidateDAO" %>
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
        ArrayList<String> city = CandidateDAO.getCity();
        StringBuffer sb = new StringBuffer();
        
        System.out.println(sb);
        displayBlock.append("<form method='POST' enctype='multipart/form-data' id='fileUploadForm'>");
        displayBlock.append("<table>");
        displayBlock.append("<tr><th>UserId:</th><td>" + cd.getCandidateId() + "</td></tr>");
        displayBlock.append("<tr><th>Candidate Name:</th><td>" + cd.getCandidateName() + "</td></tr>");
        displayBlock.append("<tr><th>City:</th><td>" + "<input type='text' id='city'>" + "</td></tr>");
        displayBlock.append("<tr><th>Party:</th><td>" + "<input type='text' id='party'>" + "</td></tr>");
        displayBlock.append("<tr><th>Symbol:</th><td>" + "<input type='file' name='files' value='Select Image'>" + "</td></tr>");
        displayBlock.append("<tr><th><input type='button' value='Update' onclick='updateCandidate()' id='updatecnd'></th>");
        displayBlock.append("</table></form>");
        
        JSONObject json = new JSONObject();
        json.put("subdetails",displayBlock.toString());
        out.println(json);
    }
    
%>
