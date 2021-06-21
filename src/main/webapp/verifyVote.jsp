<%-- 
    Document   : verifyVote
    Created on : 21-Jun-2021, 12:17:35 pm
    Author     : adarshkumar
--%>

<%
    String userID = (String)session.getAttribute("userID");
    if (userID == null){
        session.invalidate();
        response.sendRedirect("accessDenied");
        return;
    }
    boolean result = (boolean)request.getAttribute("result");
    if (result == true){
        out.println("success");
    }
    else{
        out.println("failed");
    }
%>