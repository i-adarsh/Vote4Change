<%-- 
    Document   : genderResult
    Created on : 23-Jun-2021, 4:17:35 pm
    Author     : adarshkumar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%
    String userID = (String)session.getAttribute("userID");
    if (userID == null){
        session.invalidate();
        response.sendRedirect("accessDenied.html");
        return;
    }
    String per = (String)request.getAttribute("per");
    String [] percentage = per.split(":");
    float male = (Float.parseFloat(percentage[0])/Float.parseFloat(percentage[1]) * 100);
    StringBuffer displayBlock = new StringBuffer("<table>");
    displayBlock.append("<tr><th> Gender </th><th> Vote % </th></tr>");
    displayBlock.append("<tr><td> Male </td><td>" + male + "</td><tr>");
    displayBlock.append("<tr><td> Female </td><td>" + (100 - male) + "</td><tr>");
    out.println(displayBlock);
%>
