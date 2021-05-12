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
<!--<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>-->
