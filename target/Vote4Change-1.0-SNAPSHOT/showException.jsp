<%-- 
    Document   : showException
    Created on : 12-May-2021, 12:42:29 pm
    Author     : adarshkumar
--%>

    <%@page contentType="text/html" pageEncoding="UTF-8"%>
        <%
    Exception ex = (Exception)request.getAttribute("Exception");
    System.out.println("Exception is:" + ex);
    out.println("Some Exception Occurred:" + ex.getMessage());

%>