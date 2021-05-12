<%-- 
    Document   : registrationResponse
    Created on : 12-May-2021, 12:36:54 pm
    Author     : adarshkumar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    boolean result = (boolean)request.getAttribute("result");
    boolean userFound = (boolean)request.getAttribute("userFound");
    if (userFound == true){
        out.println("uap");
    }
    else if (result == true){
        out.println("success");
    }
    else{
        out.println("error");
    }

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
