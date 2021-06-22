<%-- 
    Document   : votingResponse
    Created on : 21-Jun-2021, 12:40:36 pm
    Author     : adarshkumar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="evoting.dto.CandidateInfo" %>

<html>
    <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
            <link href="stylesheet/backgroundimage.css" rel="stylesheet">
            <link href="stylesheet/pageheader.css" rel="stylesheet">
            <link href="stylesheet/showcandidate.css" rel="stylesheet">
            <title>Voting Details</title>
    </head>
    <body>
        <%
            String userID = (String)session.getAttribute("userID");
                if (userID == null){
                    response.sendRedirect("accessDenied.html");
                    return;
                }
            CandidateInfo candidate = (CandidateInfo)session.getAttribute("candidate");
            System.out.println("Candidate VoResponse: " + candidate);
            StringBuffer displayBlock = new StringBuffer();
            displayBlock.append("<div class='sticky'><div class='candidate'>VOTE FOR CHANGE</div><br>");
            if (candidate == null){
                displayBlock.append("<div class='subcandidate'>Sorry! Your vote could not be casted</div><br><br>");
                displayBlock.append("<div><h4 id='logout'><a href='LoginControllerServlet?logout=logout'>Logout</a></h4></div>");
                out.println(displayBlock);
            }
            else{
                displayBlock.append("<div class='subcandidate'>Thank You for Voting</div><br><br>");
                displayBlock.append("<br /><div class='candidateprofile'>Your vote added Successfully</div>");
                displayBlock.append("<br /><div class='candidateprofile'><p>Candidate Id:" + candidate.getCandidateId() + "<br>");
                displayBlock.append("<strong>You voted for </strong><br /><img src='data:image/jpg;base64,"+candidate.getSymbol()+"' style='width:300px;height:200px;'/>");
                displayBlock.append("<br /><div class='candidateprofile'><p>Candidate Id:" + candidate.getCandidateId() + "<br>");
                displayBlock.append("Candidate Name:" + candidate.getCandidateName() + "<br>");
                displayBlock.append("Party:" + candidate.getParty() + "<br></div>");
                out.println(displayBlock);
            }
        %>
    </body>
</html>
