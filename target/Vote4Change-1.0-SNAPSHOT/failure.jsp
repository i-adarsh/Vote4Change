<%-- 
    Document   : failure
    Created on : 02-Jun-2021, 11:41:16 pm
    Author     : adarshkumar
--%>

<%
    String userId = (String)session.getAttribute("userID");
    if(userId == null){
        session.invalidate();
        response.sendRedirect("accessDenied.html");
        return;
    }
    out.println("failed");
%>