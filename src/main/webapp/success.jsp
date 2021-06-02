<%-- 
    Document   : success
    Created on : 02-Jun-2021, 11:38:28 pm
    Author     : adarshkumar
--%>

<%
    String userId = (String)session.getAttribute("userId");
    if(userId == null){
        session.invalidate();
        response.sendRedirect("accessDenied.html");
        return;
    }
    out.println("success");
%>