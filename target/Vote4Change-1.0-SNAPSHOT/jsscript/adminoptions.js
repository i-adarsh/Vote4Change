function redirectadministratorpage()
{
    swal("Admin!","Redirecting To Admin Actions Page!","success").then(value=>{
        window.location="adminactions.jsp";
    });
}
function redirectvotingpage()
{
    swal("Admin!","Redirecting To Voting Controller Page!","success").then(value=>{
        window.location="VotingControllerServlet";
    });
}
function manageuser()
{
    swal("Admin!","Redirecting To User Management Page!","success").then(value=>{
        window.location="manageuser.jsp";
    });
}
function managecandidate()
{
    swal("Admin!","Redirecting To Candidate Management Page!","success").then(value=>{
        window.location="managecandidate.jsp";
    });
}