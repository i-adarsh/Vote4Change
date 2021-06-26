<%-- 
    Document   : registrationResponse
    Created on : 12-May-2021, 12:36:54 pm
    Author     : adarshkumar
--%>

    <%@page contentType="text/html" pageEncoding="UTF-8"%>
        <%
    boolean result = (boolean)request.getAttribute("result");
    boolean userFound = (boolean)request.getAttribute("userFound");
    String username = (String)request.getAttribute("userName");
    if (userFound == true){
        out.println("uap");
    }
    if (result == true){
        System.out.println("true : Success");
        out.println("success");
    }
    else{
        out.println("error");
    }

%>