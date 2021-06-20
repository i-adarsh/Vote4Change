<%-- 
    Document   : loginResponse
    Created on : 12-May-2021, 3:12:03 pm
    Author     : adarshkumar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String userID = (String)request.getAttribute("userID");
    String result = (String)request.getAttribute("result");
    if (userID != null && result != null){
        HttpSession sessionID = request.getSession();
        sessionID.setAttribute("userID", userID);
        String url = "";
        if(result.equalsIgnoreCase("Admin")){
            url = "AdminControllerServlet;jsessionid="+sessionID.getId();
        }
        else{
            url = "VotingControllerServlet;jsessionid="+sessionID.getId();
        }
        out.println(url);
    }
    else{
        out.println("error");
    }
%>