<%-- 
    Document   : adminOptions
    Created on : 17-May-2021, 9:53:58 pm
    Author     : adarshkumar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="jsscript/adminoptions.js"></script>
        <script src="jsscript/jquery.js"></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <link rel="stylesheet" href="stylesheet/backgroundimage.css"/>
        <link rel="stylesheet" href="stylesheet/pageheader.css"/>
        <<link rel="stylesheet" href="stylesheet/admin.css"/>
        <title>Admin Options</title>
    </head>
    <body>
        <%
            String userID = (String)session.getAttribute("userID");
            if (userID == null){
                response.sendRedirect("accessDenied.html");
                return;
            }
            StringBuffer displayBlock = new StringBuffer(
            "<div class="sticky">  "
            + " "sticky" "
            + ""
            + ""+""
            );
        %>
    </body>
</html>
