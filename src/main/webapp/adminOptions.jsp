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
            StringBuffer displayBlock = new StringBuffer("<div class=\"sticky\"> <div class=\"candidate\">VOTE FOR CHANGE</div><br />" +
                " <div class=\"subcandidate\">Admin Actions Page</div><br /><br />" +
                " <div calss=\"logout\"><a href=\"login.html\"logout</a></div></div>");
            displayBlock.append("<div class=\"container\">");
            displayBlock.append("<div id=\"dv1\" onclick=\"redirectadministratorpage()\">\n" +
                "        <img src=\"images/administrator.png\" height=\"300px\" width=\"300px\"/><br />\n" +
                "        <h3>Admin Options</h3>\n" +
                "        </div>");
        
            displayBlock.append("<div id=\"dv2\" onclick=\"redirectvotingpage()\">\n" +
                "                <img src=\"images/voteadmin.jpg\" height=\"300px\" width=\"300px\"/><br />\n" +
                "                <h3>Voting Page</h3>\n" +
                "                </div>\n" +
                "                </div>");
            displayBlock.append("<br /><br />\n" +
                "                <div align=\"center\" id=\"result\"></div>");
            out.println(displayBlock);
        %>
    </body>
</html>
